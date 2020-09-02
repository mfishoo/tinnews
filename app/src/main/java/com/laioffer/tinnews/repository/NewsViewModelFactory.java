package com.laioffer.tinnews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.laioffer.tinnews.ui.home.HomeViewModel;
import com.laioffer.tinnews.ui.search.SearchViewModle;

public class NewsViewModelFactory implements ViewModelProvider.Factory {
    private final NewsRepository repository;

    public NewsViewModelFactory(NewsRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(HomeViewModel.class)){
            return (T) new HomeViewModel(repository);
        }else if (modelClass.isAssignableFrom(SearchViewModle.class)){
            return (T) new SearchViewModle(repository);
        }else {
            throw new IllegalStateException("Unknown ViewModel");
        }
    }
}
