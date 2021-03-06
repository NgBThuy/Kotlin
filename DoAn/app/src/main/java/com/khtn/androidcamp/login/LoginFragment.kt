package com.khtn.androidcamp.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.khtn.androidcamp.BaseFragment
import com.khtn.androidcamp.MainActivity
import com.khtn.androidcamp.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseFragment() {

    interface Listener {
        fun openRegisterScreen()
        fun openForgotScreen()
    }

    lateinit var mListener: Listener

    lateinit var mAuth: FirebaseAuth

    override fun getTagName(): String {
        return LoginFragment::class.java.simpleName
    }

    override fun inflateView(): Int {
        return R.layout.login_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        initFirebase()
    }

    private fun initFirebase() {
        mAuth = FirebaseAuth.getInstance()
    }

    private fun initViews() {
        tvRegister.setOnClickListener {
            mListener.openRegisterScreen()
        }

        tvReset.setOnClickListener {
            mListener.openForgotScreen()
        }

        btnLogin.setOnClickListener {
            val email = edtmail.text.toString().trim()
            val password = edPassword.text.toString().trim()
            mAuth.signInWithEmailAndPassword(email,password)
                .addOnFailureListener {
                    Toast.makeText(context,"Login Failed: ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
                }.addOnSuccessListener {
                    Toast.makeText(context,"Login success: ${it.user.email}", Toast.LENGTH_SHORT).show()
                    //val currentUser = mAuth.currentUser
                    //updateUI(currentUser)
                    val intent = Intent(activity, MainActivity::class.java)
                    //intent.putExtra("act", 1)
                    startActivity(intent)
                }.addOnCanceledListener {
                    Toast.makeText(context,"Login Canceled ", Toast.LENGTH_SHORT).show()
                }

        }
    }

    fun setListener(listener: Listener) {
        mListener = listener
    }


}