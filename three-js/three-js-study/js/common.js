function buildScene() {
    return new THREE.Scene();
}

function buildPerspectiveCamera(fov, w, h, near, far, position) {
    var camera = new THREE.PerspectiveCamera(fov, w / h, near, far);
    camera.position.x = position.x;
    camera.position.y = position.y;
    camera.position.z = position.z;

    camera.up.x = 0;
    camera.up.x = 0;
    camera.up.z = 1;
    return camera;
}

function buildRenderer(w, h) {
    var renderer = new THREE.WebGLRenderer({antialias: true});
    renderer.setSize(w, h);
    renderer.setClearColor(0xffffff, 1.0);
    return renderer;
}