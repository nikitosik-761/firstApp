package com.example.epl

import androidx.fragment.app.Fragment

 abstract class BaseMainActivityFragment(layoutId: Int): Fragment(layoutId) {
     val mainActivity by lazy {
         activity as MainActivity
     }


}