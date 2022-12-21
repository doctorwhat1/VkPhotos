package com.example.vkphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import coil.load
import com.example.vkphotos.MainActivity.Companion.globalVar

class PhotosActivity : AppCompatActivity() {

    private lateinit var imageView1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)


        // test ripping
        globalVar = "{\"response\":{\"count\":2,\"items\":[{\"album_id\":289932900,\"date\":1670930166,\"id\":457259258,\"owner_id\":222690449,\"sizes\":[{\"height\":75,\"type\":\"s\",\"width\":73,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=73x75&quality=95&sign=7ac112cb1c8aa998b4be48899758f8a2&c_uniq_tag=q940jKIpAIuBLWMzRbvteLXLl2Qxn13R3RzJtnX3AlI&type=album\"},{\"height\":97,\"type\":\"m\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"x\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"o\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"p\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"q\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"},{\"height\":97,\"type\":\"r\",\"width\":95,\"url\":\"https:\\/\\/sun9-46.userapi.com\\/impg\\/hB6DR7Hs72JA5wffoYPww2cHxXr4oMEhmSIVDg\\/zQlFY8qaZp0.jpg?size=95x97&quality=95&sign=9c08eaf3e7c0a644f3a167b0f7699429&c_uniq_tag=kuYWYYrZ-5uyUA3NCe4odJgklwOQAO7wKARf97otBOA&type=album\"}],\"text\":\"\"},{\"album_id\":289932900,\"date\":1670930172,\"id\":457259259,\"owner_id\":222690449,\"sizes\":[{\"height\":50,\"type\":\"s\",\"width\":75,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=75x50&quality=95&sign=3fa4a3a6fa6178b5a0c053d31af0c901&c_uniq_tag=mZahnekzHs-SWR-Z3Ju2LjUYKcsDIyBLGKiXYO9RL4s&type=album\"},{\"height\":87,\"type\":\"m\",\"width\":130,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=130x87&quality=95&sign=840d4be767327ab6114c0af522de1622&c_uniq_tag=feoa_eyFZvR20YMxYAbfrFRAYGv_4VKgKyNkDMUuPrY&type=album\"},{\"height\":403,\"type\":\"x\",\"width\":604,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=604x403&quality=95&sign=7ab668ba83e7373d60bdf1c357b85f9c&c_uniq_tag=_nac_5W7mBMK_w13_tmHVk1GWYReCcC7L_8CTZu2oSQ&type=album\"},{\"height\":538,\"type\":\"y\",\"width\":807,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=807x538&quality=95&sign=b6159f58d4f105880a0e6fa6d458c118&c_uniq_tag=X419tmORYMRqQUYIrJzH1geBupO90CoetKUaPDvIrls&type=album\"},{\"height\":800,\"type\":\"z\",\"width\":1200,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=1200x800&quality=95&sign=2b24df43a67ab9b7f4bc22e99842a4b2&c_uniq_tag=QYZ0hdtIqkcNzRmKaCU97bepV1hsJGvJxPmlGh3m5ug&type=album\"},{\"height\":87,\"type\":\"o\",\"width\":130,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=130x87&quality=95&sign=840d4be767327ab6114c0af522de1622&c_uniq_tag=feoa_eyFZvR20YMxYAbfrFRAYGv_4VKgKyNkDMUuPrY&type=album\"},{\"height\":133,\"type\":\"p\",\"width\":200,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=200x133&quality=95&sign=864907f4a501b79a1b03fe292ac5bcc7&c_uniq_tag=tSVCUTBzt3R4rHJjSLGhWmT_R2niYs0pcaQx8cuedFc&type=album\"},{\"height\":213,\"type\":\"q\",\"width\":320,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=320x213&quality=95&sign=b5669c1a49e48ceddf7e483392ff0a05&c_uniq_tag=jrH58Ur5mLoeJc_1QcUrle4dkCjxfSjkjjuFJTZFdaY&type=album\"},{\"height\":340,\"type\":\"r\",\"width\":510,\"url\":\"https:\\/\\/sun9-35.userapi.com\\/impg\\/p54jFmGDRQCqFR9M128QiNrG6RH3QLz0OeA-zg\\/ALxaYbs3TII.jpg?size=510x340&quality=95&sign=4e95fbd5d6651ede80c8e7061aae93cd&c_uniq_tag=ctlRn4nMwu-mbCdQW_YsBxdxrx-0M7UFxOFBgPtjok4&type=album\"}],\"text\":\"\"}]}}"

        val separate1 = globalVar.split("\"".toRegex()).map { it.trim() }
        var separate2 = arrayOf<String>()

        for(item: String in separate1)
            if (item.length>20) {
                separate2 += item
                // println(item) // add to sep2
            }
        println(separate2)


        imageView1 = findViewById(R.id.imageView1)


        //values from 0 to 16 are valid
        imageView1.load(separate2[12])


        //plan
        // rip the response json for links to pictures
        // store links in an array
        // transform them using a lib
        // show them in grid view or recycler view?




    }


}