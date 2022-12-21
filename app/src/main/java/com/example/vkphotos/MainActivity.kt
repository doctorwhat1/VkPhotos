package com.example.vkphotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        var globalVar = "empty"
    }

    private val client = OkHttpClient()
    private lateinit var textView1 : TextView
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = findViewById(R.id.helloWorldTXT)
        button1 = findViewById(R.id.button1)

        println("\nlol2")

//        // test ripping
//        globalVar = "{\"response\":{\"count\":2,\"items\":[{\"album_id\":289932900,\"date\":1670930166,\"id\":457259258,\"owner_id\":222690449,\"sizes\":[{\"height\":75,\"type\":\"s\",\"width\":73,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=73x75&quality=95&sign=7ac112cb1c8aa998b4be48899758f8a2&c_uniq_tag=q940jKIpAIuBLWMzRbvteLXLl2Qxn13R3RzJtnX3AlI&type=album\"},{\"height\":97,\"type\":\"m\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"x\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"o\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"p\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"q\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"r\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"}],\"text\":\"\"},{\"album_id\":289932900,\"date\":1670930172,\"id\":457259259,\"owner_id\":222690449,\"sizes\":[{\"height\":50,\"type\":\"s\",\"width\":75,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=75x50&quality=95&sign=3fa4a3a6fa6178b5a0c053d31af0c901&c_uniq_tag=mZahnekzHs-SWR-Z3Ju2LjUYKcsDIyBLGKiXYO9RL4s&type=album\"},{\"height\":87,\"type\":\"m\",\"width\":130,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=130x87&quality=95&sign=840d4be767327ab6114c0af522de1622&c_uniq_tag=feoa_eyFZvR20YMxYAbfrFRAYGv_4VKgKyNkDMUuPrY&type=album\"},{\"height\":403,\"type\":\"x\",\"width\":604,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=604x403&quality=95&sign=7ab668ba83e7373d60bdf1c357b85f9c&c_uniq_tag=_nac_5W7mBMK_w13_tmHVk1GWYReCcC7L_8CTZu2oSQ&type=album\"},{\"height\":538,\"type\":\"y\",\"width\":807,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=807x538&quality=95&sign=b6159f58d4f105880a0e6fa6d458c118&c_uniq_tag=X419tmORYMRqQUYIrJzH1geBupO90CoetKUaPDvIrls&type=album\"},{\"height\":800,\"type\":\"z\",\"width\":1200,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=1200x800&quality=95&sign=2b24df43a67ab9b7f4bc22e99842a4b2&c_uniq_tag=QYZ0hdtIqkcNzRmKaCU97bepV1hsJGvJxPmlGh3m5ug&type=album\"},{\"height\":87,\"type\":\"o\",\"width\":130,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=130x87&quality=95&sign=840d4be767327ab6114c0af522de1622&c_uniq_tag=feoa_eyFZvR20YMxYAbfrFRAYGv_4VKgKyNkDMUuPrY&type=album\"},{\"height\":133,\"type\":\"p\",\"width\":200,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=200x133&quality=95&sign=864907f4a501b79a1b03fe292ac5bcc7&c_uniq_tag=tSVCUTBzt3R4rHJjSLGhWmT_R2niYs0pcaQx8cuedFc&type=album\"},{\"height\":213,\"type\":\"q\",\"width\":320,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=320x213&quality=95&sign=b5669c1a49e48ceddf7e483392ff0a05&c_uniq_tag=jrH58Ur5mLoeJc_1QcUrle4dkCjxfSjkjjuFJTZFdaY&type=album\"},{\"height\":340,\"type\":\"r\",\"width\":510,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=510x340&quality=95&sign=4e95fbd5d6651ede80c8e7061aae93cd&c_uniq_tag=ctlRn4nMwu-mbCdQW_YsBxdxrx-0M7UFxOFBgPtjok4&type=album\"}],\"text\":\"\"}]}}"
//
//        val separate1 = globalVar.split("\"".toRegex()).map { it.trim() }
//        var separate2 = arrayOf<String>()
//
//        for(item: String in separate1)
//            if (item.length>20) {
//                separate2 += item
//               // println(item) // add to sep2
//            }
//        println(separate2)


        // println(separate1)



      //  var ResponseStr : String

        // vk cur token ="https://oauth.vk.com/blank.html#access_token=vk1.a.iWRjV_LuAG1_Lg-oRYvWAq-jIRs1rVJbeaGbGbKF30-KP6rCjkmbW9V-Ptd1UXT8wM4Vh2lWgR0rbaDyOiJNWnJGSRzIvwTudYkVxEI1Kio0Ddq91AiuWE4MrKXtFrx2kqJG2PB6G8xSDyaqKLTJZ-loje0bw7nNT0G9t_L7LVsutbgdtKwU7D-SPR-ZHw_e&expires_in=86400&user_id=222690449"
        // photos get with token= "https://api.vk.com/method/photos.get?owner_id=222690449&album_id=289932900&v=5.81&access_token=vk1.a.iWRjV_LuAG1_Lg-oRYvWAq-jIRs1rVJbeaGbGbKF30-KP6rCjkmbW9V-Ptd1UXT8wM4Vh2lWgR0rbaDyOiJNWnJGSRzIvwTudYkVxEI1Kio0Ddq91AiuWE4MrKXtFrx2kqJG2PB6G8xSDyaqKLTJZ-loje0bw7nNT0G9t_L7LVsutbgdtKwU7D-SPR-ZHw_e"
        //
//        GlobalScope.launch {
//          //  ResponseStr = getRequest("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&page=pizza&format=json")
//          getRequest("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&page=pizza&format=json")
//
//        }

        button1.setOnClickListener()
        {
            println("lol333")
            GlobalScope.launch {
                getRequest("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&page=pizza&format=json").toString()
            }
            Thread.sleep(1_200)
            textView1.text = globalVar
            val intent = Intent(this, PhotosActivity::class.java)
            startActivity(intent)
            // goto view photos activity
            //   get photos from url + photoadapter
            // got view albums activity
            //   get albums from url + albumadapter
        }

//        GlobalScope.launch {
//            val result = httpGet("http://hmkcode-api.appspot.com/rest/api/hello/Android")
//        }

        }


        suspend fun getRequest(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("error")
            }
            override fun onResponse(call: Call, response: Response) {
               // println(response.body()?.string())
                var test = "123"
                var textString = response.body()?.string()
                textString = textString.toString()
                globalVar = textString
                //placeText(textString)

//                lateinit var textView1 : TextView
//                textView1 = findViewById(R.id.helloWorldTXT)
//                textView1.setText(response.body()?.string())
                //return response.body()?.string()
          //      textView1.setText(response.body()?.string())
                //return (response.body()?.string())

            }
        })
    }


//    private suspend fun httpGet(myURL: String?): String? {
//
//        val result = withContext(Dispatchers.IO) {
//            val inputStream: InputStream
//
//
//            // create URL
//            val url: URL = URL(myURL)
//
//            // create HttpURLConnection
//            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
//
//            // make GET request to the given URL
//            conn.connect()
//
//            // receive response as inputStream
//            inputStream = conn.inputStream
//
//            // convert inputstream to string
//            if (inputStream != null)
//                //convertInputStreamToString(inputStream)
//                inputStream.toString()
//            else
//                "Did not work!"
//
//
//        }
//        return result
//    }


}