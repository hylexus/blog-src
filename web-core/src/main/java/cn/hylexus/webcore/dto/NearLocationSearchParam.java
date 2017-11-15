package cn.hylexus.webcore.dto;

/**
 * 附近位置搜索条件
 *
 * @author hylexus
 */
public class NearLocationSearchParam {

    private Double targetLng;
    private Double targetLat;

    private Integer start;
    private Integer limit;

    private Double lng1;
    private Double lng2;
    private Double lat1;
    private Double lat2;


    public void setLng1(Double lng1) {
        this.lng1 = lng1;
    }

    public void setLng2(Double lng2) {
        this.lng2 = lng2;
    }

    public void setLat1(Double lat1) {
        this.lat1 = lat1;
    }

    public void setLat2(Double lat2) {
        this.lat2 = lat2;
    }

    public Double getLng1() {
        return lng1;
    }

    public Double getLng2() {
        return lng2;
    }

    public Double getLat1() {
        return lat1;
    }

    public Double getLat2() {
        return lat2;
    }

    public void setTargetLng(Double targetLng) {
        this.targetLng = targetLng;
    }

    public void setTargetLat(Double targetLat) {
        this.targetLat = targetLat;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Double getTargetLng() {
        return targetLng;
    }

    public Double getTargetLat() {
        return targetLat;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NearLocationSearchParam{");
        sb.append(", targetLng=").append(targetLng);
        sb.append(", targetLat=").append(targetLat);
        sb.append(", start=").append(start);
        sb.append(", limit=").append(limit);
        sb.append('}');
        return sb.toString();
    }
}