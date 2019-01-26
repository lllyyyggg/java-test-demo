package pattern.action;

import java.util.ArrayList;
import java.util.List;

public class ServiceLocatorTest {
    interface Service {
        String getName();

        void execute();
    }

    static class Service1 implements Service {
        @Override
        public String getName() {
            return "Service1";
        }

        @Override
        public void execute() {
            System.out.println("Service one execute");
        }
    }

    static class Service2 implements Service {
        @Override
        public String getName() {
            return "Service2";
        }

        @Override
        public void execute() {
            System.out.println("Service two execute");
        }
    }

    // Do the real job
    static class Context {
        public Object lookup(String jndiName) {
            if (jndiName.equalsIgnoreCase("SERVICE1")) {
                System.out.println("Looking up and creating a new Service1 object");
                return new Service1();
            } else {
                System.out.println("Looking up and creating a new Service2 object");
                return new Service2();
            }
        }
    }

    static class Cache {
        private List<Service> services;

        public Cache() {
            this.services = new ArrayList<>();
        }

        public Service getService(String serviceName) {
            for (Service service : services) {
                if (service.getName().equalsIgnoreCase(serviceName)) {
                    System.out.println("Returning cached " + serviceName + " object");
                    return service;
                }
            }
            return null;
        }

        public void addService(Service newService) {
            for (Service service : services) {
                if (service.getName().equalsIgnoreCase(newService.getName())) {
                    services.add(newService);
                    return;
                }
            }
            services.add(newService);
        }
    }

    static class ServiceLocator {
        private final static Cache cache;

        static {
            cache = new Cache();
        }

        public static Service locate(String jnidName) {
            Service service = cache.getService(jnidName);
            if (null != service) {
                return service;
            }
            Context context = new Context();
            service = (Service) context.lookup(jnidName);
            cache.addService(service);
            return service;
        }
    }

    public static void main(String[] args) {
        Service service = ServiceLocator.locate("Service1");
        service.execute();
        service = ServiceLocator.locate("service2");
        service.execute();
        service = ServiceLocator.locate("service1");
        service.execute();
        service = ServiceLocator.locate("service2");
        service.execute();
    }
}
