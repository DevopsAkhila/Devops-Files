def call() {
    echo "===== Environment Details ====="
    echo "Job: ${env.JOB_NAME}"
    echo "Build: ${env.BUILD_NUMBER}"
    echo "Branch: ${env.BRANCH_NAME}"
    echo "Node: ${env.NODE_NAME}"
}
