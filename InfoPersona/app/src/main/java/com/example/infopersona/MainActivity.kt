package com.example.infopersona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var et_Nombre:EditText
    private lateinit var et_Apellido:EditText
    private lateinit var spinner_Departamento:Spinner
    private lateinit var spinner_Municipio:Spinner
    private lateinit var rb_Musculino:RadioButton
    private lateinit var rb_Femenino:RadioButton
    private lateinit var etp_Telefono:EditText
    private lateinit var tv_Resultado:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_Nombre =  findViewById(R.id.et_Nombre)
        et_Apellido = findViewById(R.id.et_Apellido)
        spinner_Departamento = findViewById(R.id.spinner_Departamento)
        spinner_Municipio = findViewById(R.id.spinner_Municipio)
        rb_Musculino = findViewById(R.id.rb_Musculino)
        rb_Femenino = findViewById(R.id.rb_Femenino)
        etp_Telefono = findViewById(R.id.etp_Telefono)
        tv_Resultado = findViewById(R.id.tv_Resultado)

        val opciones = arrayOf(
            "Seleccione una opcion",
            "San Salvador",
            "Chalatenango",
            "Sonsonate",
            "La Paz",
            "La Libertad",
            "San Miguel",
            "Usulután",
            "Cabañas",
            "Santa Ana",
            "San Vicente",
            "La Unión",
            "Morazán",
            "Cuscatlán",
            "Ahuachapán"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        spinner_Departamento.adapter = adaptador

        fun getMunicipios(depto:String):ArrayList<String>{
            val muni= arrayListOf<String>()
            when(depto){
                "Chalatenango"->muni.addAll(listOf("Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                    "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                    "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                    "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                    "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->muni.addAll(listOf("Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                    "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                    "Soyapango","Tonacatepeque"))
                "Sonsonate"->muni.addAll(listOf("Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                    "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                    "Sonzacate"))
                "La Paz"->muni.addAll(listOf("Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                    "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                    "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                    "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->muni.addAll(listOf("Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                    "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                    "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->muni.addAll(listOf("Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                    "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                    "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->muni.addAll(listOf("Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                    "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                    "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->muni.addAll(listOf("Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                    "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->muni.addAll(listOf("Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                    "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->muni.addAll(listOf("Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                    "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->muni.addAll(listOf("Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                    "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->muni.addAll(listOf("Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                    "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                    "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->muni.addAll(listOf("Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                    "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                    "Suchitoto","Tenancingo"))
                "Ahuachapán"->muni.addAll(listOf("Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                    "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }
            return muni
        }

        spinner_Departamento?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var depart:String=spinner_Departamento.selectedItem.toString()
                val adaptadorMuni = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, getMunicipios(depart))
                spinner_Municipio.adapter=adaptadorMuni

            }
        }
    }

    var resultado = ""

    fun Guardar(Vista:View){
        val Nombre = et_Nombre.text.toString()
        val Apellido = et_Apellido.text.toString()
        val Departamento = spinner_Departamento.selectedItem.toString()
        val Municipio = spinner_Municipio.selectedItem.toString()
        val Telefono = etp_Telefono.text.toString()

        val Celular = Integer.parseInt(Telefono)

        if (Nombre != null){
            try {
                resultado = "$Nombre / "
            }catch (e:Exception){
                Toast.makeText(this,"No se guardo su nombre... $e",Toast.LENGTH_LONG).show()
            }
        }

        if (Apellido != null){
            try {
                resultado += "$Apellido / "
            }catch (e:Exception){
                Toast.makeText(this,"No se guardo su apellido... $e",Toast.LENGTH_LONG).show()
            }
        }

        if (Departamento != null){
            try {
                resultado += "$Departamento / "
            }catch (e:Exception){
                Toast.makeText(this,"No se guardo su Departamento... $e",Toast.LENGTH_LONG).show()
            }
        }

        if (Municipio != null){
            try {
                resultado += "$Municipio / "
            }catch (e:Exception){
                Toast.makeText(this,"No se guardo su Municipio... $e",Toast.LENGTH_LONG).show()
            }
        }

        if(rb_Femenino.isChecked){
            resultado += "Femenino / "
        }else if(rb_Musculino.isChecked){
            resultado += "Masculino / "
        }

        if (Celular != null){
            try {
                resultado += "$Celular / "
            }catch (e:Exception){
                Toast.makeText(this,"No se guardo su Municipio... $e",Toast.LENGTH_LONG).show()
            }
        }

    }

    fun Imprimir(Vista: View){
        tv_Resultado.setText(resultado)
    }
}


