package uz.dossishox.manager

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(28), dp(22), dp(20))
            setBackgroundColor(Color.rgb(248, 250, 252))
        }

        val title = TextView(this).apply {
            text = "DOSSISHOX"
            textSize = 27f
            setTextColor(Color.rgb(15, 23, 42))
            gravity = Gravity.CENTER_VERTICAL
        }
        page.addView(title)

        val subtitle = TextView(this).apply {
            text = "TELEGRAM MANAGER"
            textSize = 12f
            setTextColor(Color.rgb(100, 116, 139))
            setPadding(0, dp(3), 0, dp(24))
        }
        page.addView(subtitle)

        val status = TextView(this).apply {
            text = "Telegram akkaunti ulanmagan"
            textSize = 15f
            setTextColor(Color.rgb(51, 65, 85))
            setPadding(dp(14), dp(14), dp(14), dp(14))
            setBackgroundColor(Color.WHITE)
        }
        page.addView(status)

        fun addButton(label: String, detail: String) {
            val b = Button(this).apply {
                text = label
                isAllCaps = false
                setOnClickListener {
                    Toast.makeText(this@MainActivity, detail, Toast.LENGTH_LONG).show()
                }
            }
            val lp = LinearLayout.LayoutParams(-1, dp(54))
            lp.topMargin = dp(10)
            page.addView(b, lp)
        }

        addButton("Xabarlar", "Telegram ulanishi sozlangandan keyin xabarlar shu yerda ko'rinadi.")
        addButton("Qidiruv", "Xabar qidiruvi keyingi bosqichda ulanadi.")
        addButton("Saqlanganlar", "Muhim xabarlarni saqlash keyingi bosqichda ulanadi.")
        addButton("Avtomatik javob", "Avtomatik javob sozlamalari keyingi bosqichda qo'shiladi.")
        addButton("Sozlamalar", "API ma'lumotlarini hozircha ilovaga kiritmang.")

        val note = TextView(this).apply {
            text = "Boshlang'ich maket • Telegram bilan hali ulanmagan"
            textSize = 12f
            setTextColor(Color.rgb(100, 116, 139))
            setPadding(0, dp(24), 0, 0)
        }
        page.addView(note)

        setContentView(ScrollView(this).apply { addView(page) })
    }
}
