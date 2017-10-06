package features;

import components.Page;

public class Feature extends BaseFeature {

    private Page page;

    public Feature() {
        page = new Page();
    }

    public void navigateToSearchPage(String url) {
        page.getToURL(url);
    }

    public void selectSuggestionByRequest(String request, String suggestion){
        page.enterText(request);
        page.selectItemByText(suggestion);
    }

    public String getLastLikeDislikeValue() {
        page.scrollToBottom();
        return page.getLastLikeDislikeValue();
    }
}
