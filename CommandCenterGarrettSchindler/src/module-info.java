

module commandCenterModule {
	requires javafx.graphics; 
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	opens commandCenterPackage to javafx.graphics;
}