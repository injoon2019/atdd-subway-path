package wooteco.subway.domain;

import java.util.List;
import java.util.Objects;

public class Path {

    private final List<Station> stations;
    private List<Long> lineIds;
    private final int distance;

    public Path(List<Station> stations, List<Long> lineIds, int distance) {
        this.stations = stations;
        this.lineIds = lineIds;
        this.distance = distance;
    }

    public Path(List<Station> stations, int distance) {
        this.stations = stations;
        this.distance = distance;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public List<Long> getLineIds() {
        return lineIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Path)) {
            return false;
        }
        Path path = (Path) o;
        return distance == path.distance && Objects.equals(stations, path.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations, distance);
    }
}
