#! /bin/bash
# A simple backup script for freestyle jobs in Jenkins
# This script creates a backup of the Jenkins home directory
# and stores it in s3 bucket
# Usage: ./Backupscript-freestylejob.sh
# Prerequisites: AWS CLI must be installed and configured with appropriate permissions

# Set variables
JENKINS_HOME="/var/lib/jenkins"
BACKUP_DIR="/tmp/jenkins_backup"
S3_BUCKET="s3://jenkins-server-backup-demo/jenkins_backups"
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
BACKUP_FILE="jenkins_backup_$TIMESTAMP.tar.gz"
LOG_FILE="/var/log/jenkins_backup.log"

# Create backup directory if it doesn't exist
mkdir -p $BACKUP_DIR
echo "[$(date +"%Y-%m-%d %H:%M:%S")] Starting backup process..." >> $LOG_FILE
# Create a tar.gz backup of the Jenkins home directory
tar -czf $BACKUP_DIR/$BACKUP_FILE -C $JENKINS_HOME .
if [ $? -ne 0 ]; then
    echo "[$(date +"%Y-%m-%d %H:%M:%S")] Error creating backup archive." >> $LOG_FILE
    exit 1
fi
echo "[$(date +"%Y-%m-%d %H:%M:%S")] Backup archive created: $BACKUP_FILE" >> $LOG_FILE     
# Upload the backup to S3
aws s3 cp $BACKUP_DIR/$BACKUP_FILE $S3_BUCKET/$BACKUP_FILE
if [ $? -ne 0 ]; then
    echo "[$(date +"%Y-%m-%d %H:%M:%S")] Error uploading backup to S3." >> $LOG_FILE
    exit 1
fi
echo "[$(date +"%Y-%m-%d %H:%M:%S")]    Backup uploaded to S3: $S3_BUCKET/$BACKUP_FILE" >> $LOG_FILE        
# ===============================
# Delete backups older than 2 days
# ===============================
find $BACKUP_DIR -type f -mtime +2 -name "*.tar.gz" -exec rm {} \;

echo "Backup Completed Successfully!"
