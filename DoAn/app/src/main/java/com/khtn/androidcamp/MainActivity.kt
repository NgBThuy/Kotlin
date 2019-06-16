package com.khtn.androidcamp

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.khtn.androidcamp.chat.ChatActivity
import com.khtn.androidcamp.login.LoginActivity
import com.khtn.androidcamp.profile.ProfileActivity
import com.khtn.androidcamp.upbook.BookAdapter
import com.khtn.androidcamp.upbook.InfoActivity
import com.khtn.androidcamp.upbook.Information
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_book.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mAuth: FirebaseAuth
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val rootDB = firebaseDatabase.reference

    private var adapter: BookAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }


        registerListener()

        checkUser()

        initViews()

        setupRecyclerView()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navView.setNavigationItemSelectedListener(this)

    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_up_book -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_mess -> {
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_login -> {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_logout -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirmation")
                    .setMessage("Are you sure to remove this user?")
                    .setPositiveButton("OK") { _, _ ->
                        mAuth.signOut()
                    }
                    .setNegativeButton(
                        "Cancel"
                    ) { dialog, _ -> dialog?.dismiss() }

                val myDialog = builder.create()
                myDialog.show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }


        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun checkUser() {
        mAuth = FirebaseAuth.getInstance()
        val user = FirebaseAuth.getInstance().currentUser
        //Toast.makeText(this,user.getValue().email)
        if (user == null) {
            startActivity(Intent(this, LoginActivity::class.java))
//        }else{
//            getInfoUser()
        }
    }

    private fun initViews() {
        btn_add.setOnClickListener{
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }


    }
    private fun setupRecyclerView() {
        val lm = LinearLayoutManager(this)
        rv_upbook?.layoutManager = lm
        rv_upbook?.setHasFixedSize(true)
        adapter = BookAdapter(this@MainActivity)
        rv_upbook?.adapter = adapter
    }

    private fun registerListener() {
        // data chat
        rootDB.child("Information").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                if (dataSnapshot.exists()) {
                    val m = dataSnapshot.getValue(Information::class.java)
                    if (m != null) {
                        Log.e(TAGG, ">>>>> 11$s")
                        adapter!!.addData(m)
                        rv_upbook?.smoothScrollToPosition(adapter!!.itemCount)
                        tv_dt_namebook?.setText("")
                        tv_dt_author?.setText("")
                        tv_dt_info_book?.setText("")
                        tv_dt_city?.setText("")
                        tv_dt_contact?.setText("")
                    }
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {

            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {

            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }

    companion object {
        private val TAGG = MainActivity::class.java.simpleName
    }

}
