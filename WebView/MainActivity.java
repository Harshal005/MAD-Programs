


public class MainActivity extends AppCompatActivity {

    String username = "Abc";
    String password = "123";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.mespune.in/home/");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        // Override onBackPressed method to handle WebView back navigation
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            // If there's history, go back in the WebView
            webView.goBack();
        } else {
            // Otherwise, handle the back press normally
            super.onBackPressed();
        }
    }
    }
}










