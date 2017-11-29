package com.bel.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private var mAuth= FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener { signIn() }
        register.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    //======= signIn fun Firebase
    private fun signIn(){
        val email:String=email.text.toString()
        val password:String=password.text.toString()

        if(email.isEmpty()){
            Toast.makeText(this,"Please Enter Your Email", Toast.LENGTH_LONG).show()
            return
        }
        if(password.isEmpty()){
            Toast.makeText(this,"Please Enter Your Password", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Done Successfully !!",Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this," Failled !!"+task.exception?.message, Toast.LENGTH_LONG).show()

                    }
                })
    }
    //====== end fun

}
