package software.amazon.awssdk.services.cloudwatchlogs.emf.sinks;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import software.amazon.awssdk.services.cloudwatchlogs.emf.model.MetricsContext;

import java.util.List;

/**
 * Convenience helper for sinking the same log items to multiple destinations.
 *
 * Useful for debugging, sink to CloudWatch and console.
 */
@Builder
public class MultiSink implements ISink {
    @Singular
    @NonNull
    private List<ISink> sinks;

    @Override
    public void accept(MetricsContext context) {
        for (ISink sink : sinks) {
            sink.accept(context);
        }
    }
}
