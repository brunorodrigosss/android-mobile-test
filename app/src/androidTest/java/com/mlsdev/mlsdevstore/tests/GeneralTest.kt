package com.mlsdev.mlsdevstore.tests


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mlsdev.mlsdevstore.presentaion.splashscreen.SplashScreenActivity
import com.mlsdev.mlsdevstore.tests.account.robots.action.actionAccount
import com.mlsdev.mlsdevstore.tests.baby.constants.BabyConstants
import com.mlsdev.mlsdevstore.tests.cart.constants.CartConstants
import com.mlsdev.mlsdevstore.tests.cart.robots.action.actionCart
import com.mlsdev.mlsdevstore.tests.cart.robots.asserts.assertCart
import com.mlsdev.mlsdevstore.tests.categories.constants.CategoriesConstants
import com.mlsdev.mlsdevstore.tests.categories.robot.action.actionCategory
import com.mlsdev.mlsdevstore.tests.checkout.robots.action.actionCheckout
import com.mlsdev.mlsdevstore.tests.consumerEletronics.constants.ConsumerEletronicsConstants
import com.mlsdev.mlsdevstore.tests.consumerEletronics.robots.actionConsumerEletronics
import com.mlsdev.mlsdevstore.tests.favorites.robots.action.actionFavorites
import com.mlsdev.mlsdevstore.tests.favorites.robots.asserts.assertFavorites
import com.mlsdev.mlsdevstore.tests.healthBeauty.constants.HealthBeautyConstants
import com.mlsdev.mlsdevstore.tests.healthBeauty.robots.action.actionHealthBeauty
import com.mlsdev.mlsdevstore.tests.itemDetails.robots.action.actionItemDetails
import com.mlsdev.mlsdevstore.tests.personalInfo.robots.action.actionPersonalInfo
import com.mlsdev.mlsdevstore.tests.shippingInfo.robots.action.actionShippingInfo
import com.mlsdev.mlsdevstore.tests.store.robots.action.actionStore
import com.mlsdev.mlsdevstore.tests.store.robots.arrange.arrangeStore
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by bruno.soares on 2019-06-19.
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class GeneralTest {
    @get:Rule
    val mActivityTestRule: ActivityTestRule<SplashScreenActivity> = ActivityTestRule(SplashScreenActivity::class.java)

    @Before
    fun setUp() {
        arrangeStore {
            assyncWait()
        }
    }

    @Test
    fun addItemAsFavorite() {
        actionStore {
            store_clickButtoBrowseCategories()
        }
        actionCategory {
            categories_clickCategory(CategoriesConstants.CONSUMER_ELETRONICS)
        }
        actionConsumerEletronics {
            clickProductList(ConsumerEletronicsConstants.TV)
            closeErrorMessage()
        }
        actionItemDetails {
            itemDetails_clickFavoriteIcon()
        }
        actionFavorites {
            favorites_clickFavoritesTabbar()
        }
        assertFavorites {
            favorites_assertFavorites(ConsumerEletronicsConstants.TV)
        }
    }

    @Test
    fun addAndRemoveItemFromCart() {
        actionStore {
            store_clickButtoBrowseCategories()
        }
        actionCategory {
            categories_clickCategory(CategoriesConstants.CONSUMER_ELETRONICS)
        }
        actionConsumerEletronics {
            clickProductList(ConsumerEletronicsConstants.TV)
            closeErrorMessage()
        }
        actionItemDetails {
            itemDetails_clickAddToCart()
        }
        actionCart {
            clickCartTabbar()
            cart_removeProduct()
        }
        assertCart {
            cart_assertCart(CartConstants.NO_ITENS)
        }
    }

    @Test
    fun buyHealthBeautyAndBabyCategoriesSucessfully(){
        addAccountInformation()

        actionStore {
            clickStoreTabbar()
            store_clickButtoBrowseCategories()
        }

        addProductToCart(CategoriesConstants.HEALTH_BEAUTY, HealthBeautyConstants.MAKEUP)
        addProductToCart(CategoriesConstants.BABY, BabyConstants.PRODUCT)

        actionCart {
            clickCartTabbar()
            cart_clickCheckout()
        }
        actionCheckout {
            checkout_fillCardInformation("4111111111111111", "0101", "6666", "Bruno")
            checkout_clickPlaceOrder()
            closeErrorMessage()
        }
    }

    fun addProductToCart(category: String, product: String){
        actionCategory {
            categories_clickCategory(category)
        }
        actionHealthBeauty {
            clickProductList(product)
            closeErrorMessage()
        }
        actionItemDetails {
            itemDetails_clickAddToCart()
        }
        actionStore {
            clickStoreTabbar()
            store_clickButtoBrowseCategories()
        }
    }

    fun addAccountInformation() {
        actionAccount {
            clickAccountTabbar()
            account_editPersonalInfo()
        }
        actionPersonalInfo {
            personalInfo_fillPersonalInfo("email@email.com", "firstName", "lastName")
            personalInfo_clickSubmitButton()
        }
        actionAccount {
            account_editShippingInfo()
        }
        actionShippingInfo {
            personalInfo_fillShippingInfo("1988888888", "Osvaldo Benedito Gonçalves", "Campinas",
                    "SP", "130000")
        }
    }

}