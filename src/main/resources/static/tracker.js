var style_blue = {strokeColor: "#0000CD", strokeOpacity: 0.5, strokeWidth: 4.5};
var gridProjection = new OpenSpace.GridProjection();
var stompClient = null;

function initmapbuilder() {
    lastPoint = null
    osMap = new OpenSpace.Map('map', {resolutions: [2500, 1000, 500, 200, 100, 50, 25, 10, 5, 4, 2.5, 2, 1]} );
    loadHistory();
    //startPullUpdates();
    startPushUpdates();
}

function loadHistory(){
    $.getJSON("/history", function(data, status){
        var points = [];
        var mapPoint;
        for( let point of data ){
            mapPoint = gridProjection.getMapPointFromLonLat( new OpenLayers.LonLat(point.lon, point.lat) );
            thisPoint = new OpenLayers.Geometry.Point( mapPoint.getEasting(), mapPoint.getNorthing() );
            points.push( thisPoint );
        }
        var lineString = new OpenLayers.Geometry.LineString( points );
        var lineFeature = new OpenLayers.Feature.Vector(lineString, null, style_blue);
        osMap.getVectorLayer().addFeatures([lineFeature]);
        lastPoint = thisPoint;
        osMap.setCenter( mapPoint, 7 );
    });
}

function startPullUpdates(){
    $.getJSON("/latest.json", function(position, status){
        processUpdate(position);
        setTimeout(startPullUpdates,10000);
    });
}

function startPushUpdates() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/position', function (message) {
            processUpdate(JSON.parse(message.body));
        });
    });
}

function processUpdate( position ) {
    mapPoint = gridProjection.getMapPointFromLonLat( new OpenLayers.LonLat(position.lon, position.lat) );
    thisPoint = new OpenLayers.Geometry.Point( mapPoint.getEasting(), mapPoint.getNorthing() );
    if ( !!lastPoint && !thisPoint.equals(lastPoint) ) {
        var lineString = new OpenLayers.Geometry.LineString([thisPoint, lastPoint]);
        var lineFeature = new OpenLayers.Feature.Vector(lineString, null, style_blue);
        osMap.getVectorLayer().addFeatures([lineFeature]);
        osMap.setCenter( mapPoint );
    }
    lastPoint = thisPoint;
}