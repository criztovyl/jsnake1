@SuppressWarnings("JavaModuleNaming") // the numbers are modules names not versions
module de.ciis0.experiements.jsnake1.jsnake1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.slf4j;


    opens de.ciis0.experiements.jsnake1.jsnake1 to javafx.fxml;
    exports de.ciis0.experiements.jsnake1.jsnake1;
}