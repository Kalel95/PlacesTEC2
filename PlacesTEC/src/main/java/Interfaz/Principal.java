/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import PlacesTEC.capalogica.Api.ApiPlaces;
import PlacesTEC.capalogica.Api.DistaciaMatrixApi;
import PlacesTEC.capalogica.Api.GoogleGeocoderService;
import PlacesTEC.capalogica.Estructuras.ANodoArbol;
import PlacesTEC.capalogica.Estructuras.ArbolBinario;
import PlacesTEC.capalogica.Estructuras.Favoritos;
import PlacesTEC.capalogica.Estructuras.Lugar;
import PlacesTEC.capalogica.logica.BD4O;
import com.db4o.ObjectSet;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.LatLng;
import com.google.maps.errors.ApiException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;
/**
 *
 * @author Joel
 */
public class Principal extends javax.swing.JFrame {
    int contador=0;
    TextAutoCompleter AutoCompletar;
    //Se crea el modelo de las Tablas
    DefaultTableModel tabla1= new DefaultTableModel();
    DefaultTableModel tSInteres= new DefaultTableModel();
    DefaultTableModel tablaruta= new DefaultTableModel();
    
    BD4O Basedatos=new BD4O();
    static Lugar usuarios;
    //ObjectSet resultado;
    static String x="";
    static ArbolBinario arbol;
    
    public Principal() {
        initComponents();
        //Se ingresa la informacion de las tablas
        tabla1.addColumn("Fecha");
        tabla1.addColumn("Locacion");
        tabla1.addColumn("Latitud");
        tabla1.addColumn("Longitud");
        tSInteres.addColumn("Imagen");
        tSInteres.addColumn("ID");
        tSInteres.addColumn("TEL");
        tSInteres.addColumn("Ratin");
        tSInteres.addColumn("Horario");
        tSInteres.addColumn("Web");
        tSInteres.addColumn("Nombre");
        tablaruta.addColumn("Destino");
        tablaruta.addColumn("Llegada");
        jTable3.setModel(tablaruta);
        //Se muestran en la tabla 2 los lugares guardados
        for(int i=0;i<Basedatos.ConsultarLugares().size();i++) {
            Lugar lu = (Lugar)Basedatos.ConsultarLugares().get(i);
            String Dato[]=new String[4];
            String ID=lu.getDia()+"/"+lu.getMes()+"/"+lu.getAño();
            String id= String.valueOf(ID);
            Dato[0]= id;
            Dato[1]= lu.getLugar();
            Dato[2]=lu.getLatitud();
            Dato[3]=lu.getLongitud();
            tabla1.addRow(Dato);
        }
        //metodo para buscar lugares mediante el autocompletado-sin ingresar la palabra completa
        ApiPlaces completar = new ApiPlaces();       
        ArrayList resp=completar.AutoCompletado("san");
        AutoCompletar= new TextAutoCompleter( jTextField4 );
        AutoCompletar.addItems(resp);
        
        
        
        //Se inician las tablas con la informacion ya establesida
        jTable1.setModel(tabla1);
        jTable2.setDefaultRenderer(Object.class, new TablaImagen());
        //tSInteres.addRow(new Object[]{new JLabel(new ImageIcon(getClass().getResource("Interfaz\\Imagenes\\a.png")))});
        jTable2.setModel(tSInteres);
        
        
        //ArrayList<String> resp1= new ArrayList<String>(); 
        //resp1=completar.AutoCompletado("Cartago");
        //AutoCompletar.addItems();
        AutoCompletar.setCaseSensitive(false); 
    }
    //--------------------------------------------------------------------------------------------
    public void InfSInteres(double Lat, double Long, int radio, String TipLInteres) {
        GooglePlaces client = new GooglePlaces("AIzaSyCeK84BmV_6d1hRdtb5l5hIaX_7JrobptU");
        Param a = new Param("type="+TipLInteres);
        //9.8666386,-83.921331
        List<Place> places = client.getNearbyPlaces(Lat, Long, radio, GooglePlaces.MAXIMUM_RESULTS, a);
        
        System.out.println(places.size());
        int num=places.size();
        System.out.println(Arrays.deepToString(places.toArray()));
        for(int i=0; i<num; i++) {
            Place place = places.get(i).getDetails();
            Object[] fila = new Object[7];
            try{
                //ImageIcon icono=new ImageIcon(place.getIconImage());
                fila[0]= new JLabel(new ImageIcon(getClass().getResource("/Desktop/tiger-1526704_960_720.png")));  
            }
            catch(Exception ex){fila[0]= new JLabel("no se encontro"); }
            fila[1]= place.getPlaceId();
            fila[2]= place.getInternationalPhoneNumber();
            fila[3]= place.getRating();
            fila[4]= place.getHours();
            fila[5]= place.getWebsite();
            fila[6]= place.getName();
            //System.out.println(place.getPhotos().get(i).getImage().toString());
            System.out.println("Lat: " + place.getWebsite());
            System.out.println("Long: " + place.getLongitude());
            System.out.println("Adress: " + place.getAddress());
            tSInteres.addRow(fila);
        }
        jTable2.setModel(tSInteres);
    }
    //--------------------------------------------------------------------------------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1350, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 80, -1));
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, -1));

        jLabel8.setText("Código");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 80, -1));

        jLabel1.setText("Latitud");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, -1));

        jLabel2.setText("Longitud");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Dirección ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setText("Medio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, -1));

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 80, -1));

        jLabel5.setText("Dia");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 30, -1));

        jLabel6.setText("Mes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 30, -1));

        jLabel7.setText("Año");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 24, -1));
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 40, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, -1));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 80, -1));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 80, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Bicicleta", "Automóvil", "Caminando" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 80, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 80, -1));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel10.setText("Lugar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jButton6.setText("Aceptar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 500, 180));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, -1));

        jLabel11.setText("Rango:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jButton8.setText("Buscar Radio");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "restaurant", "cinema", "doctor", "museum", "bar" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel12.setText("Tipo de Sitio:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 20));

        jTable1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lugar", "Latitud", "Longitud"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 310, 100));

        jLabel13.setText("Locacion");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jTable2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lugar", "Latitud", "Longitud"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 550, 150));

        jLabel14.setText("Sitios de interes:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jButton9.setText("AgregarFav");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 90, 30));

        jButton10.setText("Consulta");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 90, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 710, 380));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 500, 190));

        jButton11.setText("Calcular");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 80, 30));

        jButton7.setText("Agregar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 520, 260));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Lugares de Destino");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 240, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Sitios de Interes");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("Ruta de Viaje");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Geocoder d = new Geocoder();
        GoogleGeocoderService c = new GoogleGeocoderService(d);
        try {
            //validar que los jtextfield no esten vacíos
          if((jTextField1.getText() == null || jTextField1.getText().equals(""))||
         (jTextField2.getText() == null || jTextField2.getText().equals(""))){
              
              if((jTextField3.getText() == null || jTextField3.getText().equals(""))){        
                 if(jTextField4.getText()==null|| jTextField4.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Debe completar la latitud y longitud o la dirección ");
                  }
                  else{
                      LatLng location = c.locationToCoordinate(jTextField4.getText()).getLocation();
                    //System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                    //JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                    //location.getLng());
                  
                    String latitud = location.getLat().toString();      
                    String longitud = location.getLng().toString();
                    //int codigo=Integer.parseInt(jTextField8.getText());
                    //se crea un objeto tipo Constructor       
                    
                    System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                    JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                    location.getLng());
                  }
              }
              else{
                 LatLng location = c.locationToCoordinate(jTextField3.getText()).getLocation();
                 System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                 JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                    location.getLng());
              }
           }
           else if((jTextField3.getText() == null || jTextField3.getText().equals(""))){
               if((jTextField1.getText()) != null ||(jTextField2.getText() == null )){
            GeocoderGeometry h = new GeocoderGeometry();
            LatLng j = new LatLng(jTextField1.getText(), jTextField2.getText());
            h.setLocation(j);
            System.out.println(c.coordinateToLocation(h));
            JOptionPane.showMessageDialog(null,c.coordinateToLocation(h));
               }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //validar que los jtextfield no esten vacíos
        if(/*(jTextField1.getText() == null || jTextField1.getText().equals(""))||
                (jTextField2.getText() == null || jTextField2.getText().equals(""))||
                (jTextField3.getText() == null || jTextField3.getText().equals(""))||*/
                (jComboBox1.getSelectedIndex() <1 || jComboBox1.getSelectedItem().toString()=="Seleccionar")||
                (jTextField5.getText() == null || jTextField5.getText().equals(""))||
                (jTextField6.getText() == null || jTextField6.getText().equals(""))||
                (jTextField7.getText() == null || jTextField7.getText().equals(""))||
                (jTextField8.getText() == null || jTextField7.getText().equals(""))){
            JOptionPane.showMessageDialog(null,"Debe completar los espacios vacios");
        }
        else{                   
            Geocoder d = new Geocoder();
            GoogleGeocoderService c = new GoogleGeocoderService(d);
        try {
            //validar que los jtextfield no esten vacíos
          if((jTextField1.getText() == null || jTextField1.getText().equals(""))||
         (jTextField2.getText() == null || jTextField2.getText().equals(""))){
              
              if((jTextField3.getText() == null || jTextField3.getText().equals(""))){
                  if(jTextField4.getText()==null|| jTextField4.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Debe completar la latitud y longitud o la dirección ");
                  }
                  else{
                      LatLng location = c.locationToCoordinate(jTextField4.getText()).getLocation();
                    //System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                    //JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                    //location.getLng());
                  
                    String latitud = location.getLat().toString();      
                    String longitud = location.getLng().toString();
                    //int codigo=Integer.parseInt(jTextField8.getText());
                    //se crea un objeto tipo Constructor       
                    Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,jTextField4.getText(),jComboBox1.getSelectedItem().toString(),
                    jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                    Basedatos.Insertar(persona);
                    JOptionPane.showMessageDialog(null,persona );
                    contador++;
                  }
                  
              }
              else{
                 LatLng location = c.locationToCoordinate(jTextField3.getText()).getLocation();
                 //System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                 //JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                 //location.getLng());
                  
                 String latitud = location.getLat().toString();      
                 String longitud = location.getLng().toString();
                 //int codigo=Integer.parseInt(jTextField8.getText());
                 //se crea un objeto tipo Constructor       
                 Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,jTextField3.getText(),jComboBox1.getSelectedItem().toString(),
                 jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                 Basedatos.Insertar(persona);
                 JOptionPane.showMessageDialog(null,persona );
                 contador++;
              }
           }
           else if((jTextField3.getText() == null || jTextField3.getText().equals(""))){
               if((jTextField1.getText()) != null ||(jTextField2.getText() == null )){
            GeocoderGeometry h = new GeocoderGeometry();
            LatLng j = new LatLng(jTextField1.getText(), jTextField2.getText());
            h.setLocation(j);
            System.out.println(c.coordinateToLocation(h));
                        
            String latitud = jTextField1.getText();      
            String longitud = jTextField2.getText();
            //int codigo=Integer.parseInt(jTextField8.getText());
            Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,c.coordinateToLocation(h),jComboBox1.getSelectedItem().toString(),
                 jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                 Basedatos.Insertar(persona);
                 JOptionPane.showMessageDialog(null,persona );
                 contador++;
               }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                         
		} 
        //eliminar las filas de la jtable1
        int filas=tabla1.getRowCount();
            for (int i = 0;filas>i; i++) {
                tabla1.removeRow(0);
            } 
        //actualizar la informacion que se muetra 
        for(int i=0;i<Basedatos.ConsultarLugares().size();i++) {
            Lugar lu = (Lugar)Basedatos.ConsultarLugares().get(i);
            String Dato[]=new String[4];
            String ID=lu.getDia()+"/"+lu.getMes()+"/"+lu.getAño();
            String id= String.valueOf(ID);
            Dato[0]= id;
            Dato[1]= lu.getLugar();
            Dato[2]=lu.getLatitud();
            Dato[3]=lu.getLongitud();
            tabla1.addRow(Dato);
        }
        //vaciar los texfield
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int codigo = Integer.parseInt(jTextField8.getText());
        Basedatos.Borrar(new Lugar(jTextField8.getText(),null,null,null,null,null,null,null));
        //validar que los jtextfield no esten vacíos
        if(/*(jTextField1.getText() == null || jTextField1.getText().equals(""))||
                (jTextField2.getText() == null || jTextField2.getText().equals(""))||
                (jTextField3.getText() == null || jTextField3.getText().equals(""))||*/
                (jComboBox1.getSelectedIndex() <1 || jComboBox1.getSelectedItem().toString()=="Seleccionar")||
                (jTextField5.getText() == null || jTextField5.getText().equals(""))||
                (jTextField6.getText() == null || jTextField6.getText().equals(""))||
                (jTextField7.getText() == null || jTextField7.getText().equals(""))||
                (jTextField8.getText() == null || jTextField7.getText().equals(""))){
            JOptionPane.showMessageDialog(null,"Debe completar los espacios vacios");
        }
        else{                   
            Geocoder d = new Geocoder();
            GoogleGeocoderService c = new GoogleGeocoderService(d);
        try {
            //validar que los jtextfield no esten vacíos
          if((jTextField1.getText() == null || jTextField1.getText().equals(""))||
         (jTextField2.getText() == null || jTextField2.getText().equals(""))){
              
              if((jTextField3.getText() == null || jTextField3.getText().equals(""))){
                  if(jTextField4.getText()==null|| jTextField4.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Debe completar la latitud y longitud o la dirección ");
                  }
                  else{
                      LatLng location = c.locationToCoordinate(jTextField4.getText()).getLocation();
                    //System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                    //JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                    //location.getLng());
                  
                    String latitud = location.getLat().toString();      
                    String longitud = location.getLng().toString();
                    //int codigo=Integer.parseInt(jTextField8.getText());
                    //se crea un objeto tipo Constructor       
                    Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,jTextField4.getText(),jComboBox1.getSelectedItem().toString(),
                    jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                    Basedatos.Insertar(persona);
                    JOptionPane.showMessageDialog(null,persona );
                    contador++;
                  }
                  
              }
              else{
                 LatLng location = c.locationToCoordinate(jTextField3.getText()).getLocation();
                 //System.out.println("La latitud es = " + location.getLat() + "\nLa longitud es = " + location.getLng());         
                 //JOptionPane.showMessageDialog(null,"La latitud es = " + location.getLat() + "\nLa longitud es = " + 
                 //location.getLng());
                  
                 String latitud = location.getLat().toString();      
                 String longitud = location.getLng().toString();
                 //int codigo=Integer.parseInt(jTextField8.getText());
                 //se crea un objeto tipo Constructor       
                 Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,jTextField3.getText(),jComboBox1.getSelectedItem().toString(),
                 jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                 Basedatos.Insertar(persona);
                 JOptionPane.showMessageDialog(null,persona );
                 contador++;
              }
           }
           else if((jTextField3.getText() == null || jTextField3.getText().equals(""))){
               if((jTextField1.getText()) != null ||(jTextField2.getText() == null )){
            GeocoderGeometry h = new GeocoderGeometry();
            LatLng j = new LatLng(jTextField1.getText(), jTextField2.getText());
            h.setLocation(j);
            System.out.println(c.coordinateToLocation(h));
                        
            String latitud = jTextField1.getText();      
            String longitud = jTextField2.getText();
            //int codigo=Integer.parseInt(jTextField8.getText());
            Lugar persona=new Lugar(jTextField8.getText(),latitud,longitud,c.coordinateToLocation(h),jComboBox1.getSelectedItem().toString(),
                 jTextField5.getText(),jTextField6.getText(),jTextField7.getText());
                 Basedatos.Insertar(persona);
                 JOptionPane.showMessageDialog(null,persona );
                 contador++;
               }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
                         
		} 
        //eliminar las filas de la jtable1
        int filas=tabla1.getRowCount();
            for (int i = 0;filas>i; i++) {
                tabla1.removeRow(0);
            } 
        //actualizar la informacion que se muetra 
        for(int i=0;i<Basedatos.ConsultarLugares().size();i++) {
            Lugar lu = (Lugar)Basedatos.ConsultarLugares().get(i);
            String Dato[]=new String[4];
            String ID=lu.getDia()+"/"+lu.getMes()+"/"+lu.getAño();
            String id= String.valueOf(ID);
            Dato[0]= id;
            Dato[1]= lu.getLugar();
            Dato[2]=lu.getLatitud();
            Dato[3]=lu.getLongitud();
            tabla1.addRow(Dato);
        }
        //vaciar los textfield
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
                
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //eliminar el objeto de la base de datos por medio de su codigo ID
        int codigo = Integer.parseInt(jTextField8.getText());
        Basedatos.Borrar(new Lugar(jTextField8.getText(),null,null,null,null,null,null,null));
        //Eliminar filas de la jtable1
        int filas=tabla1.getRowCount();
            for (int i = 0;filas>i; i++) {
                tabla1.removeRow(0);
            } 
        //actualizar la informacio que se muestra en jtable1
        for(int i=0;i<Basedatos.ConsultarLugares().size();i++) {
            Lugar lu = (Lugar)Basedatos.ConsultarLugares().get(i);
            String Dato[]=new String[4];
            String ID=lu.getDia()+"/"+lu.getMes()+"/"+lu.getAño();
            String id= String.valueOf(ID);
            Dato[0]= id;
            Dato[1]= lu.getLugar();
            Dato[2]=lu.getLatitud();
            Dato[3]=lu.getLongitud();
            tabla1.addRow(Dato);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //System.out.println(Basedatos.ConsultarLugares());
        JOptionPane.showMessageDialog(null,Basedatos.ConsultarLugares() );
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        if(jTextField10.getText()==null || jTextField10.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Debe ingresar un numero en los espacios");
            return;
        }
        
        int Fila=jTable1.getSelectedRow();
        if (Fila==-1) JOptionPane.showMessageDialog(null, "Seleccione una locacion");
        else if(Fila>=0){
            InfSInteres(Double.parseDouble((String)jTable1.getValueAt(Fila, 2)), 
            Double.parseDouble((String)jTable1.getValueAt(Fila, 3)), Integer.parseInt(jTextField10.getText()), 
            jComboBox2.getSelectedItem().toString());
        }
        String[] latitudLong={String.valueOf(jTable1.getValueAt(Fila, 2)),String.valueOf(jTable1.getValueAt(Fila, 3))};
        arbol=new ArbolBinario(latitudLong);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            //int codlugar = Integer.parseInt(jTextField11.getText());
            //Lugar lugar = (Lugar)Basedatos.ConsultarLugares().get(codlugar);
            //System.out.println(lugar);
            int fila=jTable1.getSelectedRow();           
            String Dato[]=new String[2];
            Dato[0]=(String) tabla1.getValueAt(fila,1);
            Dato[1]=(String) tabla1.getValueAt(fila,0);
            tablaruta.addRow(Dato);
            
        
        
           
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Favoritos fav=null;
        int Fila=jTable2.getSelectedRow();
        int Fila1=jTable1.getSelectedRow();
        if (Fila==-1) JOptionPane.showMessageDialog(null, "Seleccione un lugar");
        else if(Fila>=0){
            JLabel image =  (JLabel) tSInteres.getValueAt(Fila, 0);
            String imag = image.getText();
            String id = (String) tSInteres.getValueAt(Fila, 1);
            String tel = (String) tSInteres.getValueAt(Fila, 2);
            Double ratin = (Double) tSInteres.getValueAt(Fila, 3);
            String rating = String.valueOf(ratin);
            String horario = tSInteres.getValueAt(Fila, 4).toString();
            String web = (String) tSInteres.getValueAt(Fila, 5);
            String nombre = (String) tSInteres.getValueAt(Fila, 6);
            if((tel==null || tel.equals(""))&&(horario==null || horario.equals(""))&&(web==null || web.equals(""))){
                fav=new Favoritos(imag, id, rating, nombre);  
            }
            else if((horario==null || horario.equals(""))&&(web==null || web.equals(""))){
                fav=new Favoritos(imag, id, tel, rating, nombre);
            }
            else if((web==null || web.equals(""))){
                fav=new Favoritos(imag, id, tel, rating, horario, nombre);
            }
            else {
                fav=new Favoritos(imag, id, tel, rating, horario, web, nombre);
            }
        }
        
        String cadena = (String) tSInteres.getValueAt(Fila, 6);
        cadena=cadena.replaceAll("\\s","");
        System.out.println(cadena);
        int prioridad=0;
        for(int i=0;i<=cadena.length()-1;i++){
        prioridad+=cadena.codePointAt(i);
        }
        
        System.out.println(fav.getNombre());
        System.out.println(prioridad);
        arbol.insertar(fav, prioridad);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String nombres="";
        ANodoArbol nodo = arbol.getRaiz();
        ArrayList<Favoritos> aray=new ArrayList<>();
        aray=arbol.inOrden(nodo,aray);
        Favoritos fav=null;
        System.out.println(aray.size()-1);
        for(int i=0;i<aray.size()-1;i++){
            fav=(Favoritos) aray.get(i);
            System.out.println("Nombre: ");
            System.out.println("Nombre: "+fav.getNombre());
            nombres= nombres+fav.getNombre()+",";
        }
        
        JOptionPane.showMessageDialog(null, nombres);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String[] a = {"Cartago Province,Cartago,Costa Rica","San Jose Costa Rica"};       
        String[] b = {"San Jose Costa Rica","Cartago Province,Cartago,Costa Rica"};
        String[] result = Stream.of(a, b).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result));
        String[] p = {};       
        String[] q = {};
        int filas = tablaruta.getRowCount();
        int Fila=jTable3.getSelectedRow();
        System.out.println(filas);
        int i=0;
        /*while(i<=filas){
            String lugar=(String) tablaruta.getValueAt(Fila,1);
            System.out.println(lugar);
        String[] result = Stream.of(a, b).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result));
            
        }*/
        DistaciaMatrixApi l = new DistaciaMatrixApi();
        try {
            ArrayList w=l.impDistancia(a, b, "Automóvil");
            JOptionPane.showMessageDialog(null,w);
            return;
        } catch (ApiException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
