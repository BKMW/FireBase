package com.bel.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

/**
* register page
 * */

class MainActivity : AppCompatActivity() {
    //private val mAuth: FirebaseAuth? = null

    private var mAuth=FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register.setOnClickListener { signUp() }
    }
    //======= signUp fun Firebase
    private fun signUp(){

        val email:String=email.text.toString()
        val password:String=password.text.toString()
        val rPassword:String=rPassword.text.toString()

        if(email.isEmpty()){
            Toast.makeText(this,"Please Enter Your Email",Toast.LENGTH_LONG).show()
            return
        }
        if(password.isEmpty()){
            Toast.makeText(this,"Please Enter Your Password",Toast.LENGTH_LONG).show()
            return
        }
        if(rPassword.isEmpty()){
            Toast.makeText(this,"Please Enter Your Password Second Time", Toast.LENGTH_LONG).show()
            return
        }
        if(rPassword!=password){
            Toast.makeText(this,"Your Password Not Confirm", Toast.LENGTH_LONG).show()
            return
        }

        //==== loading
        Toast.makeText(this,"Loading...",Toast.LENGTH_LONG).show()

        mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->

                        Toast.makeText(this,"Loading...",Toast.LENGTH_LONG).show()

                        if(task.isSuccessful){
                            val intent= Intent(this,Home::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this," Failled !!"+task.exception?.message,Toast.LENGTH_LONG).show()

                        }
                    })
    }
    //====== end fun
}
