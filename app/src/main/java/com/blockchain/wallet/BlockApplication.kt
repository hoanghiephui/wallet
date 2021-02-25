package com.blockchain.wallet

import android.app.Application
import android.util.Log
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

class BlockApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /*val web3j =
            Web3j.build(HttpService("https://rinkeby.infura.io/v3/e4e5cd4f03c24a39bcb2c5d0ef9232c3"))
        val clientVersion = web3j.web3ClientVersion().sendAsync().get()
        if (clientVersion.hasError()) {
            Log.d("AAA", "Error: ${clientVersion.error.message}")
        } else {
            Log.d("AAA", "Pass: ${clientVersion.result}")
        }*/
    }
}