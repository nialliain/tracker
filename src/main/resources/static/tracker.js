var line_style = {strokeColor: "#cd0000", strokeOpacity: 0.75, strokeWidth: 5};
var gridProjection = new OpenSpace.GridProjection();
var size = new OpenLayers.Size(48,48);
var offset = new OpenLayers.Pixel(-24,-24);
var infoWindowAnchor = new OpenLayers.Pixel(36,0);
var icon = new OpenSpace.Icon('img/marker.png', size, offset, null, infoWindowAnchor);
//var popUpSize = new OpenLayers.Size(200,150);
var stompClient = null;

function initmapbuilder() {
    lastPoint = null
    osMap = new OpenSpace.Map('map', {resolutions: [2500, 1000, 500, 200, 100, 50, 25, 10, 5, 4, 2.5, 2, 1]} );
    loadHistory();
    startPushUpdates();
}

function loadHistory(){
    $.getJSON("/history", function(data, status){
        for( let point of data ){
            processUpdate(point, 7);
        }
    });
}

function startPullUpdates(){
    $.getJSON("/latest", function(position, status){
        processUpdate(position);
        setTimeout(startPullUpdates,60000);
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

function processUpdate( position, scale ) {
    mapPoint = gridProjection.getMapPointFromLonLat( new OpenLayers.LonLat(position.lon, position.lat) );
    thisPoint = new OpenLayers.Geometry.Point( mapPoint.getEasting(), mapPoint.getNorthing() );
    // Line
    if ( !!lastPoint && !thisPoint.equals(lastPoint) ) {
        var lineString = new OpenLayers.Geometry.LineString([thisPoint, lastPoint]);
        var lineFeature = new OpenLayers.Feature.Vector(lineString, null, line_style);
        osMap.getVectorLayer().addFeatures([lineFeature]);
    }
    // Marker
    osMap.createMarker(mapPoint, icon, null, null);
    // Centre
    osMap.setCenter( mapPoint, scale );
    lastPoint = thisPoint;
}