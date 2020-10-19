package com.example.entrega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.entrega.adapters.PagerAdapter
import com.example.entrega.fragments.BalonesFragment
import com.example.entrega.fragments.CubiertosFragment
import com.example.entrega.fragments.HerramientasFragment
import com.example.entrega.fragments.PastelesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tv: Toolbar

    var prevMenu:MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = appBar as Toolbar
        tv.title = getString(R.string.pastel)

        setPager(getPA())
        setNav()
    }

    private fun getPA(): PagerAdapter {
        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFrag(PastelesFragment())
        adapter.addFrag(HerramientasFragment())
        adapter.addFrag(CubiertosFragment())
        adapter.addFrag(BalonesFragment())
        return adapter
    }

    private fun setPager(adapter: PagerAdapter){
        pager.adapter = adapter
        pager.offscreenPageLimit = adapter.count
        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            //DESLIZAR
            override fun onPageSelected(position: Int) {
                prevMenu?.let { prevMenu!!.isChecked = false }
                    ?:run { nav.menu.getItem(0).isChecked = false }
                nav.menu.getItem(position).isChecked = true
                when(position){
                    0->tv.title = getString(R.string.pastel)
                    1->tv.title = getString(R.string.herramientas)
                    2->tv.title = getString(R.string.cubiertos)
                    3->tv.title = getString(R.string.balones)
                }
                prevMenu = nav.menu.getItem(position)
            }
        })
    }

    //OPRIMIR BOTON
    private fun setNav(){
        nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menupastel -> {
                    pager.currentItem = 0
                    tv.title="PASTELES"
                    true
                }
                R.id.menuherramientas -> {
                    pager.currentItem = 1
                    tv.title="HERRAMIENTAS"
                    true
                }
                R.id.menucubiertos -> {
                    pager.currentItem = 2
                    tv.title="CUBIERTOS"
                    true
                }
                R.id.menubalones -> {
                    pager.currentItem = 3
                    tv.title="BALONES"
                    true
            }
                else -> false
            }
        }
    }
}