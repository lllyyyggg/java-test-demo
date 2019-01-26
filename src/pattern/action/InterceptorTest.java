package pattern.action;

import java.util.ArrayList;
import java.util.List;

public class InterceptorTest {
    interface Filter {
        void execute(String request);
    }

    static class AuthenticationFilter implements Filter {

        @Override
        public void execute(String request) {
            System.out.println("Authenticating request : " + request);
        }
    }

    static class DebugFilter implements Filter {
        @Override
        public void execute(String request) {
            System.out.println("Debug request : " + request);
        }
    }

    static class Handler {
        public void handle(String request) {
            System.out.println("Executing request : " + request);
        }
    }

    static class FilterChain {
        private List<Filter> filters = new ArrayList<>();
        private Handler handler;

        public void addFilter(Filter filter) {
            filters.add(filter);
        }

        public void setHandler(Handler handler) {
            this.handler = handler;
        }

        public void execute(String request) {
            for (Filter filter : filters) {
                filter.execute(request);
            }
            handler.handle(request);
        }

    }

    static class FilterManager {
        private FilterChain filterChain;

        public FilterManager(Handler handler) {
            filterChain = new FilterChain();
            filterChain.setHandler(handler);
        }

        public void registerFilter(Filter filter) {
            filterChain.addFilter(filter);
        }

        public void filterRequest(String request) {
            filterChain.execute(request);
        }
    }

    static class Client {
        FilterManager filterManager;

        public void setFilterManager(FilterManager filterManager) {
            this.filterManager = filterManager;
        }

        public void sendRequest(String request) {
            filterManager.filterRequest(request);
        }
    }

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Handler());
        filterManager.registerFilter(new AuthenticationFilter());
        filterManager.registerFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
        System.out.println();
        client.sendRequest("USERS");
    }
}
