import { Kafka } from 'kafkajs';

const kafka = new Kafka({
  brokers: ['localhost:9092'],
})

const topic = 'usertopic'
const consumer = kafka.consumer({ groupId: 'group-id' })

const producer = kafka.producer();

async function run() {
  await consumer.connect()
  await consumer.subscribe({ topic })

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      console.log(`Tópico: ${topic}, Chave: ${message.key}, Mensagem: ${message.value}`)

      producer.send({
        topic: 'user-topic-response',
        messages: [
          { value: message.value }
        ]
      })
    },
  })
}

run().catch(console.error)