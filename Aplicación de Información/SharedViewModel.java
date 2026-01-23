package edu.uic.cs478.sp2025.informationapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Object> selectedItem = new MutableLiveData<>();
    private final MutableLiveData<Boolean> showDetail = new MutableLiveData<>(false);

    public LiveData<Object> getSelectedItem() { return selectedItem; }
    public LiveData<Boolean> getShowDetail() { return showDetail; }

    public void selectItem(Object item){
        selectedItem.setValue(item);
        showDetail.setValue(true);
    }

    public void clearSelection(){
        showDetail.setValue(false);
    }
}
