package pattern.action;

import java.util.List;

public class BusinessDelegateTest {
    interface Service {
        void serve();
    }

    static class EJBService implements Service {

        @Override
        public void serve() {
            System.out.println("EJB Service");
        }
    }

    static class JMSService implements Service {

        @Override
        public void serve() {
            System.out.println("JMS Service");
        }
    }

    static class ServiceLookup {
        public Service getService(String serviceType) {
            if (serviceType.equalsIgnoreCase("ejb")) {
                return new EJBService();
            } else {
                return new JMSService();
            }
        }
    }

    static class ServiceDelegate {
        private ServiceLookup serviceLookup = new ServiceLookup();
        private Service service;
        private String serviceType;

        public ServiceDelegate(String serviceType) {
            this.serviceType = serviceType;
        }

        public void doTask() {
            service = serviceLookup.getService(serviceType);
            service.serve();
        }
    }

    static class Client {
        private ServiceDelegate serviceDelegate;

        public Client(ServiceDelegate serviceDelegate) {
            this.serviceDelegate = serviceDelegate;
        }

        public void doTask() {
            serviceDelegate.doTask();
        }
    }

    public static void main(String[] args) {
        ServiceDelegate serviceDelegate = new ServiceDelegate("ejb");
        Client client = new Client(serviceDelegate);
        client.doTask();
    }
}
