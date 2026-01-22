<h1>Aplicación de Información de Eventos en Chicago</h1>

### [Demostración en YouTube](https://youtube.com/shorts/Bk-qFDOZ-S8)

<h2>Descripción</h2>
Este proyecto consiste en **dos aplicaciones cooperativas para Android 15 (API 35)**:

* **Aplicación Selector (App1)** – Un lanzador sencillo con dos botones. Cada botón muestra un mensaje emergente (toast) y envía un intent implícito (`ACTION_SHOW_ATTRACTIONS` o `ACTION_SHOW_RESTAURANTS`).

* **Aplicación de Información (App2)** – Recibe estas transmisiones mediante receptores declarados en el manifiesto y abre una de dos actividades:
  * **AttractionsActivity** – Lista de cinco atracciones de Chicago + WebView para el elemento seleccionado.
  * **RestaurantsActivity** – Lista de cinco restaurantes de Chicago + WebView para el elemento seleccionado.

Ambas actividades se inician en modo de un solo panel (solo lista). Después de que el usuario selecciona un elemento, la interfaz cambia a un diseño de dos paneles (lista ≈ ⅓, WebView ≈ ⅔). El estado se conserva mediante un `ViewModel` compartido con `LiveData`.

<br />

<h2>Lenguajes y utilidades utilizados</h2>

- <b>Java</b> (Activities, Fragments, BroadcastReceivers, ViewModel)
- <b>XML</b> (Diseños, manifiesto, recursos)
- <b>Android Jetpack</b> (ViewModel, LiveData, RecyclerView, WebView)

<h2>Entornos utilizados</h2>

- <b>Android Studio Iguana</b>
- <b>Android 15 (API 35)</b> emulador Pixel 8

<h2>Recorrido del programa:</h2>

<p align="center">
Aplicación selector con dos botones:<br/>
<img src="https://i.imgur.com/wodKef1.png" height="40%" width="40%" alt="Aplicación Selector"/>
<br /><br />
Transmisión recibida: la aplicación de información abre RestaurantsActivity:<br/>
<img src="https://i.imgur.com/RspMu1P.jpeg" height="40%" width="40%" alt="Lista de Restaurantes"/>
<br /><br />
El usuario pulsa “Portillo’s Hot Dogs”: aparece el diseño de dos paneles:<br/>
<img src="https://i.imgur.com/a2Mzf8Z.png" height="40%" width="40%" alt="Diseño de Dos Paneles"/>
<br /><br />
El menú de opciones permite volver a las atracciones:<br/>
<img src="https://i.imgur.com/8w9YWpK.png" height="40%" width="40%" alt="Menú de Opciones"/>
<br /><br />
Lista de atracciones después de la transmisión:<br/>
<img src="https://i.imgur.com/Va96jBA.png" height="40%" width="40%" alt="Lista de Atracciones"/>
</p>
