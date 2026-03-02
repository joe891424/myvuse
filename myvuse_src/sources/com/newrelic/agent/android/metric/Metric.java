package com.newrelic.agent.android.metric;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: loaded from: classes6.dex */
public class Metric extends HarvestableObject {
    private long count;
    private Double exclusive;
    private Double max;
    private Double min;
    private String name;
    private String scope;
    private Double sumOfSquares;
    private Double total;

    public Metric(String str) {
        this(str, null);
    }

    public Metric(String str, String str2) {
        this.name = str;
        this.scope = str2;
        this.count = 0L;
    }

    public Metric(Metric metric) {
        this.name = metric.getName();
        this.scope = metric.getScope();
        this.min = Double.valueOf(metric.getMin());
        this.max = Double.valueOf(metric.getMax());
        this.total = Double.valueOf(metric.getTotal());
        this.sumOfSquares = Double.valueOf(metric.getSumOfSquares());
        this.exclusive = Double.valueOf(metric.getExclusive());
        this.count = metric.getCount();
    }

    public void sample(double d) {
        this.count++;
        Double d2 = this.total;
        if (d2 == null) {
            this.total = Double.valueOf(d);
            this.sumOfSquares = Double.valueOf(d * d);
        } else {
            this.total = Double.valueOf(d2.doubleValue() + d);
            this.sumOfSquares = Double.valueOf(this.sumOfSquares.doubleValue() + (d * d));
        }
        setMin(Double.valueOf(d));
        setMax(Double.valueOf(d));
    }

    public void sampleMetricDataUsage(double d, double d2) {
        this.count++;
        Double d3 = this.total;
        if (d3 == null) {
            this.total = Double.valueOf(d);
        } else {
            this.total = Double.valueOf(d3.doubleValue() + d);
        }
        Double d4 = this.exclusive;
        if (d4 == null) {
            this.exclusive = Double.valueOf(d2);
        } else {
            this.exclusive = Double.valueOf(d4.doubleValue() + d2);
        }
        this.sumOfSquares = Double.valueOf(0.0d);
        this.min = Double.valueOf(0.0d);
        this.max = Double.valueOf(0.0d);
    }

    public void setMin(Double d) {
        if (d == null) {
            return;
        }
        if (this.min == null) {
            this.min = d;
        } else if (d.doubleValue() < this.min.doubleValue()) {
            this.min = d;
        }
    }

    public void setMinFieldValue(Double d) {
        this.min = d;
    }

    public void setMax(Double d) {
        if (d == null) {
            return;
        }
        if (this.max == null) {
            this.max = d;
        } else if (d.doubleValue() > this.max.doubleValue()) {
            this.max = d;
        }
    }

    public void setMaxFieldValue(Double d) {
        this.max = d;
    }

    public void aggregate(Metric metric) {
        if (metric == null) {
            return;
        }
        increment(metric.getCount());
        if (metric.isCountOnly()) {
            return;
        }
        Double d = this.total;
        this.total = Double.valueOf(d == null ? metric.getTotal() : d.doubleValue() + metric.getTotal());
        Double d2 = this.sumOfSquares;
        this.sumOfSquares = Double.valueOf(d2 == null ? metric.getSumOfSquares() : d2.doubleValue() + metric.getSumOfSquares());
        Double d3 = this.exclusive;
        this.exclusive = Double.valueOf(d3 == null ? metric.getExclusive() : d3.doubleValue() + metric.getExclusive());
        setMin(Double.valueOf(metric.getMin()));
        setMax(Double.valueOf(metric.getMax()));
    }

    public void increment(long j) {
        this.count += j;
    }

    public void increment() {
        increment(1L);
    }

    public double getSumOfSquares() {
        Double d = this.sumOfSquares;
        if (d == null || d.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.sumOfSquares.doubleValue();
    }

    public long getCount() {
        return this.count;
    }

    public double getExclusive() {
        Double d = this.exclusive;
        if (d == null || d.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.exclusive.doubleValue();
    }

    public void addExclusive(double d) {
        Double d2 = this.exclusive;
        if (d2 == null) {
            this.exclusive = Double.valueOf(d);
        } else {
            this.exclusive = Double.valueOf(d2.doubleValue() + d);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getScope() {
        return this.scope;
    }

    public String getStringScope() {
        String str = this.scope;
        return str == null ? "" : str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public double getMin() {
        Double d = this.min;
        if (d == null || d.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.min.doubleValue();
    }

    public double getMax() {
        Double d = this.max;
        if (d == null || d.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.max.doubleValue();
    }

    public double getTotal() {
        Double d = this.total;
        if (d == null || d.doubleValue() < 0.0d) {
            return 0.0d;
        }
        return this.total.doubleValue();
    }

    public void setTotal(Double d) {
        this.total = d;
    }

    public void setSumOfSquares(Double d) {
        this.sumOfSquares = d;
    }

    public void setExclusive(Double d) {
        this.exclusive = d;
    }

    public void setCount(long j) {
        this.count = j;
    }

    public void clear() {
        this.min = null;
        this.max = null;
        this.total = null;
        this.sumOfSquares = null;
        this.exclusive = null;
        this.count = 0L;
    }

    public boolean isCountOnly() {
        return this.total == null;
    }

    public boolean isScoped() {
        return this.scope != null;
    }

    public boolean isUnscoped() {
        return this.scope == null;
    }

    @Override // com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonElement asJson() {
        if (isCountOnly()) {
            return new JsonPrimitive(Long.valueOf(this.count));
        }
        return asJsonObject();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(NewHtcHomeBadger.COUNT, new JsonPrimitive(Long.valueOf(this.count)));
        if (this.total != null) {
            jsonObject.add("total", new JsonPrimitive(this.total));
        }
        if (this.min != null) {
            jsonObject.add("min", new JsonPrimitive(this.min));
        }
        if (this.max != null) {
            jsonObject.add("max", new JsonPrimitive(this.max));
        }
        if (this.sumOfSquares != null) {
            jsonObject.add("sum_of_squares", new JsonPrimitive(this.sumOfSquares));
        }
        if (this.exclusive != null) {
            jsonObject.add("exclusive", new JsonPrimitive(this.exclusive));
        }
        return jsonObject;
    }

    public String toString() {
        return "Metric{count=" + this.count + ", total=" + this.total + ", max=" + this.max + ", min=" + this.min + ", scope='" + this.scope + "', name='" + this.name + "', exclusive='" + this.exclusive + "', sumofsquares='" + this.sumOfSquares + "'}";
    }
}
