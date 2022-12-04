package com.example.epl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit



class MainActivity() : AppCompatActivity(), SoccerTileInterface {

    lateinit var soccerTileList: ArrayList<SoccerTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soccerTileList = getList()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, ListFragment())
        }
    }



    override fun onLearnMoreButtonClicked(position: Int) {
        val soccerTile = soccerTileList[position]

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            val bundle = Bundle().apply {
                putString("soccerTileId", soccerTile.id)
            }

            setCustomAnimations(
                R.anim.fragment_slide_in_right,
                R.anim.fragment_slide_out_left,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right



            )



            replace(R.id.fragment_container_view, DetailFragment().apply {
arguments = bundle
            })
        }
    }



    override fun onFavoriteClicked(position: Int) {
        val soccerTile = soccerTileList[position]
        soccerTile.isFavorite = !soccerTile.isFavorite

        (supportFragmentManager.fragments[0] as? ListFragment)?.onFavoriteClicked(position)

        SharedPreUtil.setSoccerTileFavorite(soccerTile.id,soccerTile.isFavorite)

    }

    private fun getList(): ArrayList<SoccerTile> {
        return ArrayList<SoccerTile>().apply {
            add(
                SoccerTile(
                    id = "manchester_united",
                    title = "Manchester United",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.manchester_header,
                    headerImageUrl = "https://ss.sport-express.ru/userfiles/materials/177/1774394/volga.jpg",
                    teamUrl = "https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D1%80%D0%B3%D0%B5%D0%BD%D1%88%D1%82%D0%B5%D1%80%D0%BD",
                    isFavorite = SharedPreUtil.getSoccerTileFavorite("manchester_united")


                    )
            )
            add(
                SoccerTile(
                    id = "manchester_city",
                    title = "Manchester City",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.menu_header,
                    headerImageUrl = "https://upload.wikimedia.org/wikipedia/ru/4/49/Cadillac_%28%D0%BF%D0%B5%D1%81%D0%BD%D1%8F%29.jpg",
                    teamUrl = "https://www.cadillac.ru/",
                    isFavorite = SharedPreUtil.getSoccerTileFavorite("manchester_city")


                )
            )
            add(
                SoccerTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.arsenal_header,
                    headerImageUrl = "https://sun9-38.userapi.com/RYaX-HDewtPM_lfnfyNjxPu9kAHciqIxFprLeA/5ko7WJp56Vw.jpg",
                    teamUrl = "https://www.youtube.com/channel/UC7f5bVxWsm3jlZIPDzOMcAg",
                    isFavorite = SharedPreUtil.getSoccerTileFavorite("arsenal")

                    )
            )


            add(
                SoccerTile(
                    id = "chelsea",
                    title = "Chelsea",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.chesia_header,
                    headerImageUrl = "https://miro.medium.com/max/1000/1*Kr52kpans_yMI8_9x0GKJQ.png",
                    teamUrl = "https://kotlinlang.org/",
                    isFavorite = SharedPreUtil.getSoccerTileFavorite("chelsea")

                    )
            )
        }


    }
}