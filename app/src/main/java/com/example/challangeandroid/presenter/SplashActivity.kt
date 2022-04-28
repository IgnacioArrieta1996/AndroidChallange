package com.example.challangeandroid.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //Este delay añadido al splash no es recomendable en una aplicacion en producción, ya que este
        //debe durar lo que tarda la app en realizar la conexión a la api y la logica correspondiente, por lo
        //que se lo he introducido para que se llegue apreciar el mismo.
        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
