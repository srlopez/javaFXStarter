# VSCODE + JAVA + JUNIT5 + SQLITE + JAVAFX
Para usarlo desde Windows 10 x64

## JAVA
1.- Instalar `VSCODE` de: https://code.visualstudio.com/Download


2.- Instalar `Java Extension Pack` desde Extensions   
https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

3.- Instalar `JDK 11`  
Comando `Create Java Project` -> no build tools -> {Carpeta} -> {Nombre Proyecto}

Vamos a los archivos -> src -> `App.java`  
Nos obliga a configurar JDK si no tenemos ninguno.
Configure Java Runtime

He escogido el `OpenJDK11U-jdk_x64_windows_hotspot_11.0.11_9` que señala por defecto. Lo descargamos, instalamos y `Reload window`.  
Debe aparecer como el JDK seleccionado para este proyecto.


## LIBRERÍAS

### - JUNIT5 - 
|Recurso|URL|
|-|-|
| WEB | https://junit.org/junit5/   
| Download Page |  https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone 
| jar 1.7.2 | https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.2/junit-platform-console-standalone-1.7.2.jar 

Una vez descargado lo movemos a `lib`  para que quede accesible al proyecto

### - SQLITE3 - 
|Recurso|URL|
|-|-|
| WEB | https://github.com/xerial/sqlite-jdbc  
| Download Page | https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/  
| jar 34.0 | https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.34.0/sqlite-jdbc-3.34.0.jar

Una vez descargado lo movemos a `lib`  para que quede accesible al proyecto

### - JAVAFX - 
|Recurso|URL|
|-|-|
| WEB | https://gluonhq.com/products/javafx/  
| Dowload ZIP | https://gluonhq.com/download/javafx-11-0-2-sdk-windows/

Extraemos y movemos a `lib` la carpeta` javafx-sdk-11.0.2` para que quede accesible al proyecto

Podemos probar una simple aplicación desde https://docs.oracle.com/javafx/2/get_started/hello_world.htm

Al ir a correr el proyecto obtendremos el mensaje:  
>Error: faltan los componentes de JavaFX runtime y son necesarios para ejecutar esta aplicación

Debemos añadir la configuración de arranque para esta aplicación. Vamos al Menu ->  Run -> Add/Open Configuration y añadimos la configuración para este proyecto.
```json
{
    "type": "java",
    "name": "Launch App Fx",
    "request": "launch",
    "vmArgs": "--module-path lib/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml",
    "mainClass": "App",
    "projectName": "p1_1e209894"
}
```
donde indicamos en `vmArgs` el path donde hemos copiado las librerías de JavaFX


## SCENE BUILDER 
Instalamos el programa https://gluonhq.com/products/scene-builder/

Creamos una escena View.fxml. Esta es una escana con un Label, un TextField y un Button. Indicamos los Id que van a tener en code, y el nombre del método al pulsar el botón.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Menu?>
<?import javafx.scene.control.MenuBar?>
<?import javafx.scene.control.MenuItem?>
<?import javafx.scene.control.SeparatorMenuItem?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.VBox?>

<VBox prefHeight="311.0" prefWidth="311.0" xmlns="http://javafx.com/javafx/16" xmlns:fx="http://javafx.com/fxml/1">
  <children>
    <MenuBar VBox.vgrow="NEVER">
      <menus>
        <Menu mnemonicParsing="false" text="File">
          <items>
            <MenuItem mnemonicParsing="false" text="New" />
            <MenuItem mnemonicParsing="false" text="Open…" />
            <Menu mnemonicParsing="false" text="Open Recent" />
            <SeparatorMenuItem mnemonicParsing="false" />
            <MenuItem mnemonicParsing="false" text="Close" />
            <MenuItem mnemonicParsing="false" text="Save" />
            <MenuItem mnemonicParsing="false" text="Save As…" />
            <MenuItem mnemonicParsing="false" text="Revert" />
            <SeparatorMenuItem mnemonicParsing="false" />
            <MenuItem mnemonicParsing="false" text="Preferences…" />
            <SeparatorMenuItem mnemonicParsing="false" />
            <MenuItem mnemonicParsing="false" text="Quit" />
          </items>
        </Menu>
        <Menu mnemonicParsing="false" text="Edit">
          <items>
            <MenuItem mnemonicParsing="false" text="Undo" />
            <MenuItem mnemonicParsing="false" text="Redo" />
            <SeparatorMenuItem mnemonicParsing="false" />
            <MenuItem mnemonicParsing="false" text="Cut" />
            <MenuItem mnemonicParsing="false" text="Copy" />
            <MenuItem mnemonicParsing="false" text="Paste" />
            <MenuItem mnemonicParsing="false" text="Delete" />
            <SeparatorMenuItem mnemonicParsing="false" />
            <MenuItem mnemonicParsing="false" text="Select All" />
            <MenuItem mnemonicParsing="false" text="Unselect All" />
          </items>
        </Menu>
        <Menu mnemonicParsing="false" text="Help">
          <items>
            <MenuItem mnemonicParsing="false" text="About MyHelloApp" />
          </items>
        </Menu>
      </menus>
    </MenuBar>
    <AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="287.0" prefWidth="311.0" VBox.vgrow="ALWAYS">
      <children>
            <TextField fx:id="txtName" layoutX="87.0" layoutY="119.0" promptText="Introduce un nombre" text="Santi" />
            <Label layoutX="89.0" layoutY="100.0" text="Nombre" />
            <Button id="btnHello" layoutX="190.0" layoutY="154.0" mnemonicParsing="false" onAction="#cmdHello_click" text="Hello!" />
      </children>
    </AnchorPane>
  </children>
</VBox>
```
En el menu View, tenemos la opción Show Sample Controller Skeleton que nos sirve para preparar nuestro controlador.

Creamos el controlador en un archivo controller.java, Tal y como nos lo haya presentado el Scene Builder y le añadimos el código en la Action del Button.

```java
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    void cmdHello_click(ActionEvent event) {
        System.out.println("Hello "+ txtName.getText() );
    }

    @FXML
    void initialize() {

    }
}
```

Ahora ya podemos utilizarlos desde nuestra aplicación App.java
```java
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.Controller;
 
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Controller
            Controller controller = new Controller();
            // Vista
            URL location = getClass().getResource("ui/View.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            fxmlLoader.setController(controller);

            // RUN
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello from JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Espero que simplemente clonando este proyecto lo tengas perfectamente instalado.