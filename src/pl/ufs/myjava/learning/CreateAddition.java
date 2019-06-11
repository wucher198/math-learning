package pl.ufs.myjava.learning;

public class CreateAddition implements CreateEquation {
    private Integer maxInteger;
    private Integer first;
    private Integer second;

    public CreateAddition(Integer maxInteger) {
        this.maxInteger = maxInteger;
        createNext();
    }

    @Override
    public Integer getResult() {
        return first + second;
    }

    @Override
    public String getEquation() {
        return first + " + " + second;
    }

    @Override
    public boolean checkResult(Integer result) {
        return getResult().equals(result);
    }

    @Override
    public void createNext() {
        first = (int) (Math.round(Math.random() * maxInteger));
        second = (int) (Math.round(Math.random() * maxInteger));
    }
}
