package com.packt.madev.portfolio.list;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.packt.madev.AppModule;
import com.packt.madev.DaggerMainComponent;
import com.packt.madev.MainComponent;
import com.packt.madev.ProjectApplication;
import com.packt.madev.portfolio.PortfolioModule;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.Date;

import dagger.Module;
import io.reactivex.Observable;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StockPortfolioListViewActivityTest {

    PortfolioRepository portfolioRepository = mock(PortfolioRepository.class);

    @Rule
    public ActivityTestRule<StockPortfolioListViewActivity> activityRule =
            new ActivityTestRule<StockPortfolioListViewActivity>(StockPortfolioListViewActivity.class) {
                @Override
                protected void beforeActivityLaunched() {
                    replaceDaggerComponent();
                    setUpRepository();
                }
            };

    private void replaceDaggerComponent() {
        ProjectApplication app = (ProjectApplication) getInstrumentation().getTargetContext().getApplicationContext();

        MainComponent component = DaggerMainComponent.builder()
                .appModule(new AppModule(app))
                .portfolioModule(new MockedModule())
                .build();


        app.setComponent(component);
    }


    @Module
    public class MockedModule extends PortfolioModule {
        @Override
        public PortfolioRepository portfolioRepository(PortfolioRepository.RoomPortfolioRepository repository) {
            return portfolioRepository;
        }
    }

    public void setUpRepository() {
        when(portfolioRepository.getPortfolioItems())
                .thenReturn(
                        Observable.just(
                                new StockPortfolioItem("FPRS", BigDecimal.TEN, new Date())
                        )
                );
    }

    @Test
    public void list_has_an_item_for_some_stock() {
        onView(withText("FPRS")).check(matches(isDisplayed()));
    }

}