package com.khtn.androidcamp.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.khtn.androidcamp.BaseFragment
import com.khtn.androidcamp.R
import kotlinx.android.synthetic.main.forget_password_fragment.*

class ForgetPasswordFragment : BaseFragment() {
    interface Listener {
        fun openLoginScreen()
    }

    lateinit var mListener: Listener
    lateinit var mAuth: FirebaseAuth

    override fun getTagName(): String {
        return ForgetPasswordFragment::class.java.simpleName
    }

    override fun inflateView(): Int {
        return R.layout.forget_password_fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLogin.setOnClickListener {
            mListener.openLoginScreen()
        }
    }

    fun setListener(listener: Listener) {
        mListener = listener
    }


}