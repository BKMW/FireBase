package com.bel.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private var mAuth= FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //====== logout
        logout.setOnClickListener { mAuth.signOut() }
        //=== if logout to finish this activity
        mAuth.addAuthStateListener {
            if (mAuth.currentUser==null){
                this.finish()
            }
        } //===== end logout
    }
    //===== end onCreate()
}
