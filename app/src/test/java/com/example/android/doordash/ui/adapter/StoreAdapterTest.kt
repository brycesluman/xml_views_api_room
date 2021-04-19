package com.example.android.doordash.ui.adapter

import androidx.fragment.app.Fragment
import com.example.android.doordash.model.Store
import com.example.android.doordash.ui.main.MainViewModel
import com.example.android.doordash.util.ImageLoader
import com.example.android.utility.TestUtils.mokk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import java.text.SimpleDateFormat
import java.util.*


class StoreAdapterTest {
    //    private val fragment: Fragment,
//                   private val stores: List<Store>,
//                   private val imageLoader: ImageLoader = ImageLoader(),
//                   private val calendar: Calendar = Calendar.getInstance(),
//                   private val format: SimpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US
    private val fragment: Fragment = mokk()
    private val imageLoader: ImageLoader = mokk()
    private val viewModel: MainViewModel = mokk()
    private val calendar: Calendar = mokk()
    private val format: SimpleDateFormat = mokk()
    var adapter = StoreAdapter(
        fragment,
        createStoreList(),
        viewModel,
        imageLoader,
        calendar,
        format
    )

    @Before
    fun setup() {

    }

    @Test
    fun `stores are inserted correctly`() {
        Assert.assertEquals(2, adapter.itemCount)
        Assert.assertNotEquals(0, adapter.itemCount)
    }

    @Test
    fun `sets ASAP or Closed correctly`() {
//        given(calendar.time).willReturn("2021-04-01T23:01:46Z")
    }

    private fun createStoreList(): List<Store> {

        return listOf(
            Store(
                1,
                "Bryce's Pizza",
                "The best pizza this side of the Rubicon",
                "https://cdn.doordash.com/media/restaurant/cover/PANERA_WORDMARK_LOGO_4x2.png",
                "2021-04-03T03:30:00Z",
                "2021-04-02T16:25:22Z",
                null,
                true,
                true,
                false,
                33,
                true
            ),
            Store(
                2,
                "Kate's Pizza",
                "The best pizza on the other side of the Rubicon",
                "https://cdn.doordash.com/media/restaurant/cover/PANERA_WORDMARK_LOGO_4x2.png",
                "2021-04-03T03:30:00Z",
                "2021-04-02T16:25:22Z",
                null,
                true,
                true,
                true,
                45,
                false
            )
        )
    }
}