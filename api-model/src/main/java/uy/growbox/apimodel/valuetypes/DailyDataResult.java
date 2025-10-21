package uy.growbox.apimodel.valuetypes;

public final class DailyDataResult {
        public final float minimum;
        public final float maximum;
        public final float average;
        public final String date;


        public DailyDataResult(String date, float minimum, float maximum, float average) {
            this.minimum = minimum;
            this.maximum = maximum;
            this.average = average;
            this.date = date;
        }
    }