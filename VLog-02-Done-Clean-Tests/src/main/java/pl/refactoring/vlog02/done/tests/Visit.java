package pl.refactoring.vlog02.done.tests;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
class Visit {
    private Facility facility;
    private int hours;

    Visit(Facility facility, int hours) {
        this.facility = facility;
        this.hours = hours;
    }

    Facility getFacility() {
        return facility;
    }

    double countPrice() {
        return facility.countPrice(hours);
    }

    int countPoints() {
        return facility.countPoints(hours);
    }

}