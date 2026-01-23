package edu.uic.cs478.sp2025.informationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailFragment extends Fragment {
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        webView = view.findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());


        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                android.util.Log.d("WebView",
                        cm.message() + " (Line " + cm.lineNumber() + ")");
                return true;
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedViewModel viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        viewModel.getSelectedItem().observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                String url = "";
                if (item instanceof Attraction) {
                    url = ((Attraction) item).getUrl();
                } else if (item instanceof Restaurant) {
                    url = ((Restaurant) item).getUrl();
                }

                if (!url.isEmpty()) {
                    webView.loadUrl(url);
                }
            }
        });
    }
}
