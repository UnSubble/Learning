package sqlite

type Config struct {
	DriverName            string
	DbName                string
	MaxConnections        int
	MaxConnectionIdleTime int
	IsFile                bool
}
