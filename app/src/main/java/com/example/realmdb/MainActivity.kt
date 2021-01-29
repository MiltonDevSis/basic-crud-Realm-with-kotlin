package com.example.realmdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val realm = Realm.getDefaultInstance()

        val manager = RealmManager()

        //manager.insert("Teste")
        //manager.deleteById(1)
        //manager.update(2, "Foi?")
        //manager.deleteAll()
        manager.findAll()

        realm.close()
    }
}