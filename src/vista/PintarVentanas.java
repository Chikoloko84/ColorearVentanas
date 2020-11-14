package vista;

// Importamos el paquete swing para trabajar con interfaces gráficas
import javax.swing.*;
import controlador.*;

/**
 * ESTA CLASE DEBE HEREDAR DE JFRAME PARA PODER
 * CREAR LA VENTANA DE NUESTRA INTERFAZ
 */
public class PintarVentanas extends JFrame{
     
    /* Esta variable no es necesaria, pero si
     * muy recomendable, ya que nos evitará problemas
     * si hay futuras actualizaciones de la aplicacion*/
    private static final long serialVersionUID = 1L;
    
    // Creamos una lámina para colocar encima del JFrame
    public JPanel lamina = new JPanel();
    
    // Creamos los controles que tendrá nuestra lámina
    public JRadioButton rdbAzul = new JRadioButton("Azul");
    public JRadioButton rdbRojo = new JRadioButton("Rojo");
    public JRadioButton rdbVerde = new JRadioButton("Verde");
    public JTextField txtColor = new JTextField(10);
    private ButtonGroup grupoBotones = new ButtonGroup();
    
     // Declaramos una variable de tipo ControlClics
    private ControlClics ejecutarEventosClic;
 
    /**
     * METODO QUE CONECTA EL CONTROLADOR CON LA INTERFAZ GRÁFICA
     */
     
    private void ejecutarAcciones() {
         
        // Creamos una instancia de la clase controladorClics
        // Esta instancia recibe por parámetro un objeto de tipo
        // PintarVentana. Ese objeto, será esta misma clase.
        ejecutarEventosClic = new ControlClics(this);
         
        // Ahora la clase ControlClics, tiene un metodo que pone
        // a la escucha a los diferentes controles, así que,
        // llamaremos a ese método.
        ejecutarEventosClic.escucharEventos();
    }
    
    /**
     * EL CONSTRUCTOR CREA LA VENTANA, LE DA UNAS PROPIEDADES
     * Y ADEMÁS EN EL, SE INDICA QUE SE LE AGREGUE UN JPANEL
     * O LO QUE ES LO MISMO, UNA LAMINA PARA PODER AGREGAR
     * LOS CONTROLES NECESARIOS
     */
    public PintarVentanas() {
          
        // Le damos un tamaño a la ventana
        this.setSize(450, 300);
         
        // Agregamos un tículo
        this.setTitle("Colorear ventanas");
          
        // Lo centramos en pantalla
        this.setLocationRelativeTo(null);
          
        /* Le decimos que no se puede redimensionar*/
        this.setResizable(false);
          
        // Le decimos que al cerrar la ventana, acabe el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        // Agregamos una lámina a la ventana
        this.getContentPane().add(lamina);
        
        // Llamamos al método configurarLaminaYagregarControles
        configurarLaminaYagregarControles();
        
        ejecutarAcciones();
    }
    
    /**
    * ESTE MÉTODO CONFIGURA NUESTRA LÁMINA (JPANEL) Y AGREGA LOS CONTROLES
    * AL JPANEL DE NUESTRA VENTANA
    */
    private void configurarLaminaYagregarControles() {
         
        // Lo primero que debemos hacer, es darle una
        // distribución (un layout) a nuestra lámina.
        // En este caso, no utilizaremos ningún tipo de distribución
        // por lo que estableceremos el layout de la lamina (Jpanel) en null
        lamina.setLayout(null);

        // Agregamos cada RadioButton al ButtonGroup. Esto nos permite
        // que cuando seleccionemos una opción, se desactive la que
        // este seleccionada
        grupoBotones.add(rdbAzul);
        grupoBotones.add(rdbRojo);
        grupoBotones.add(rdbVerde);

        /* Damos una posicion y un tamaño (x,y, ancho, alto)
         * a cada uno de los RadioButton y al cuadro de texto*/
        rdbAzul.setBounds(10, 10, 60, 30);
        rdbRojo.setBounds(10, 40, 60, 30);
        rdbVerde.setBounds(10,70, 60, 30);
        txtColor.setBounds(10, 100, 60, 20);

        /* Desactivamos el txtColor para que no se pueda escribir*/
        txtColor.setEnabled(false);

        /* Añadimos los controles a la lamina*/
        lamina.add(rdbAzul);
        lamina.add(rdbRojo);
        lamina.add(rdbVerde);
        lamina.add(txtColor);
    }    
}