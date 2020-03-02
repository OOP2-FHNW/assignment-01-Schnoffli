package portfolio;

import portfolio.investments.Investment;

import java.util.ArrayList;
import java.util.List;

public class Portfolio <T extends Investment> {
    List<T> investments = new ArrayList<>();

    public Portfolio() {

    }

    public boolean contains(T invest) {
        return investments.contains(invest);
    }

    public void buy(T ubs) {
        if (investments.contains(ubs)) {
            for (T share : investments)
                if (share.equals(ubs))
                    share.setCount(share.getCount() + 1);
        }
        else
            investments.add(ubs);
    }

    public void sell(String ubs, double amount) {
        T  share = getShare(ubs);
            if (share != null) {
                share.setCount(share.getCount() - amount);
                if (share.getCount() == 0) {
                    share.setCount(0);
                    investments.remove(share);
                }
            }
    }

    public T getShare(String ubs) {
        for (T share : investments)
            if (share.getTitel().equals(ubs))
                return share;
        return null;
    }



    //TODO Complete this implementation and make it generic
}
