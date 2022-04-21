package edu.uw.tcss450.uiandnavigationlab.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.auth0.android.jwt.JWT;

import java.util.Map;

import edu.uw.tcss450.uiandnavigationlab.ui.blog.BlogPost;

public class CardStatusViewModel extends ViewModel {

    //Store the expanded state for each List item, true -> expanded, false -> not
    private final Map<BlogPost, Boolean> mExpandedFlags;

    /**
     *
     * @param flagStatus
     */
    private CardStatusViewModel(Map<BlogPost, Boolean> flagStatus) {
        mExpandedFlags = flagStatus;
    }

    /**
     * Mimics the map data structure put function, for keeping state of blog post status
     *
     * @param blog
     * @param status
     */
    public void put(BlogPost blog, boolean status) {
        mExpandedFlags.put(blog, status);
    }

    /**
     * Mimic map data structure get function that gets the boolean value with the blog as the key.
     *
     * @param blog
     * @return
     */
    public boolean get(BlogPost blog) {
        return mExpandedFlags.get(blog);
    }

    /**
     *
     */
    public static class CardStatusViewModelFactory implements ViewModelProvider.Factory {

        private final Map<BlogPost, Boolean> mFlagStatus;

        public CardStatusViewModelFactory(Map<BlogPost, Boolean> flagStatus) {
            this.mFlagStatus = flagStatus;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass == CardStatusViewModel.class) {
                return (T) new CardStatusViewModel(mFlagStatus);
            }
            throw new IllegalArgumentException(
                    "Argument must be: " + CardStatusViewModel.class);
        }
    }
}
