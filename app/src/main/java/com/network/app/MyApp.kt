package com.network.app

import android.app.Application
import services.vego.network.Initialize

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        /**  Set base url and headers for api */
        Initialize.networkConfig("https://api.koko-stores.com/", getHeaderMap())
    }

    private fun getHeaderMap(): HashMap<String, String> {
        val headerMap = HashMap<String, String>()
        /** if you want add header */

        headerMap["Authorization"] =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiZDg2OGVmMzdiOGE0NTg0YTFlMDQ3MzEzMWI2OWYyMTAzOGMxMDQ3ZDVmNTU4MDAyODhjZWJlODcwNzExNjIwZTQ5NDc0YjdkNWQ3ZTFkODciLCJpYXQiOjE2MDc4NDc2NjksIm5iZiI6MTYwNzg0NzY2OSwiZXhwIjoxNjM5MzgzNjY5LCJzdWIiOiIyIiwic2NvcGVzIjpbXX0.PB8oMcSLXHkd0hpAvVqCrB-2DvofS5jsViu4pJmgUE_gEspc7-_dyHb2ndoss1lOW8cJjJodhbG-DGT7HGNoAjNZLTQiRvITNQaqPK7Di2a3uViRs2L0sXU-4RfsVKRzUi9v-dK0omAFPHyaZFbv6RZB9BwkVs6UbZnukwHx1BjOPCDd76Nc-Uwj_zOXE5vmu8iMTEBjCwRFd0UDM_l519SDgqMnRiUgkeFcNDUQDMjFv_DB_9Z3SbDPf49cgTd08F2xcXIL-4VY84-fgL7Eh5NPzvWh4MV4W7e3S2mFFA9g8rAEthfOPDZQt-oqXdU7oNh_t2chgHpxmbu7eC_tey-CoIdGfjfdLoFJiI9NBu7811Hv1eRwLcYxg0mVd81ihU2y89iXI5VLWmJMFs89sfg5kynKP69cBQ2xRdA9d5s2vQXgyX8HSTZCVmaxkaLsurqY0LaE33kmxN22A76-I6wniGoP8SSR5ssnSxLRuMF1ptyHbbC5Vx40gGK3WDsL6icGSfNqP5UJ1eE6JWwLKNA8cPFSx2k-rs9M-2qcIYgywvmbmMVrnKDS_RptmfIjjE2jLiTRaxIkX54lfC9w3VlwLkhdMIHuXbV3ed3D5fkC4ZtFQf4QvkL9NNAU59uyqQ2JBVQq4OPXOxCWdOA-UuPq56LiywyGbcm-U0BKIbs"
        return headerMap
    }
}