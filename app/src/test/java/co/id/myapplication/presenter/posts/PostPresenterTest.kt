package co.id.myapplication.presenter.posts

import co.id.myapplication.data.network.ConfigRetrofit
import co.id.myapplication.view.posts.MainActivity
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class PostPresenterTest{
    @Mock
    lateinit var view : PostContract.View
    lateinit var mainView : MainActivity
    lateinit var configRetrofit : ConfigRetrofit
    lateinit var postPresenter : PostPresenter

    @Before
    fun before(){
        mainView = mock(MainActivity::class.java)
        postPresenter = PostPresenter(mainView)

    }

    @Test
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2)
    }
}