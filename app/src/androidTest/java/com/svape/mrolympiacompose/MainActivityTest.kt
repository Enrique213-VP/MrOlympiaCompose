package com.svape.mrolympiacompose

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.svape.mrolympiacompose.core.Constants.LIST_TEST_TAG
import com.svape.mrolympiacompose.ui.theme.MrOlympiaComposeTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun testFirstAndLastNameTheOlympia(){
        composeTestRule.setContent {
            MrOlympiaComposeTheme {
            }
        }
        composeTestRule.apply {
            onNodeWithTag(LIST_TEST_TAG)
                .onChildren()
                .onFirst()


            onNodeWithTag(LIST_TEST_TAG)
                .onChildren()
                .onLast()
        }
    }
}