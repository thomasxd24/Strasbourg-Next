FROM liferay/portal:7.4.3.4-ga4

# Install MySQL client
RUN apt-get update && apt-get install -y mysql-client && rm -rf /var/lib/apt/lists/*

# Switch to non-root user
USER liferay
