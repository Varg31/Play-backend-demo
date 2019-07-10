package security;

import play.filters.cors.CORSFilter;
import play.http.DefaultHttpFilters;
import play.mvc.EssentialFilter;

import javax.inject.Inject;

public class CustomFilter extends DefaultHttpFilters {
    private CORSFilter corsFilter;

    @Inject
    public CustomFilter(CORSFilter corsFilter) {
        super(corsFilter);
        this.corsFilter = corsFilter;
    }

    public EssentialFilter[] filters() {
        return new EssentialFilter[]{corsFilter.asJava()};
    }
}
